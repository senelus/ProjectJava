import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

abstract public class Parser {

    private static ArrayList<Integer> themeIndexes = new ArrayList<Integer>();

    public static ArrayList<Student> createStudentData(String pathCSV, String courseTitle, String token, String APIversion, String groupId) throws Exception {

        var vkParser = new VkHumanParser(token, APIversion, groupId);
        vkParser.createHumansData();
        var humans = vkParser.getHumans();
        var students = parseCSVtoCourse(pathCSV, courseTitle);
        var studentsData = new ArrayList<Student>();
        for (var student : students) {
            for (var human : humans) {
                var studentName = student.getFirst_name();
                var studentSurname = student.getLast_name();
                var humanName = human.getFirst_name();
                var humanSurname = human.getLast_name();
                if (studentName.equals(humanName) && studentSurname.equals(humanSurname))
                    studentsData.add(new Student(studentName, studentSurname, human.getId(), human.getBdate(), human.getCity(), human.getMobile_phone(), human.getPhoto_max_orig(), human.getFaculty_name(), human.getUniversity_name(), human.getEducation_form(), human.getCountry(), human.getSite(), human.getSex(), student.getCurrentSubjects(), student.getIndebrednessSubjects()));
            }
        }
        return studentsData;
    }


    public static ArrayList<Student> parseCSVtoCourse(String path, String title) throws IOException{
        var csvParser = new CSVParserBuilder().withSeparator(';').build();
        var csvReader = new CSVReaderBuilder(new FileReader(path)).withCSVParser(csvParser).build();
        var themesString = csvReader.readNext();
        var excercisesString = csvReader.readNext();
        var maxValueSting = csvReader.readNext();
        var themes = transformThemes(themesString, excercisesString, maxValueSting);
        var subject = new Subject(title, themes);
        var students = new ArrayList<Student>();
        try {
            String[] humanString;
            while (true) {
                var subjectArr = new ArrayList<Subject>();
                var localThemes = new ArrayList<Theme>();
                for (var theme : themes)
                    localThemes.add(theme.clone());
                subjectArr.add(new Subject(title, localThemes));
                humanString = csvReader.readNext();
                if (humanString[0].equals("")) break;
                var nameData = transformNameData(humanString[0]);
                var student = new Student(nameData[0], nameData[1], subjectArr,new ArrayList<Subject>());
                UpdateGradeToStudent(student,humanString);
                students.add(student);
            }
        }
        catch (NullPointerException e) {
            return students;
        }
        return students;
    }

    private static ArrayList<Theme> transformThemes(String[] themeStings, String[] excerciseStrings, String[] maximumStrings) {
        var themes = new ArrayList<Theme>();
        for (int i = 3; i < themeStings.length; i++) {
            if(themeStings[i].equals("")) continue;
            themeIndexes.add(i);
        }
        var themesCount = themeIndexes.stream().count();
        for (int i = 0; i < themesCount; i++) {
            var currentIndex = themeIndexes.get(i);
            var subArrayExcercises = Arrays.copyOfRange(excerciseStrings, currentIndex + 1, (i == themesCount - 1 ? currentIndex + 2: themeIndexes.get(i + 1)));
            var subArrayMaximum = Arrays.copyOfRange(maximumStrings, currentIndex + 1, (i == themesCount - 1 ? currentIndex + 2 : themeIndexes.get(i + 1)));
            var excercises = transformExcercises(subArrayExcercises, subArrayMaximum);
            themes.add(new Theme(themeStings[currentIndex], excercises));
        }
        return themes;
    }

    private static ArrayList<Exercise> transformExcercises(String[] excerciseStrings,String[] maximumStrings) {
        var excercises = new ArrayList<Exercise>();
        for(int i = 0; i < excerciseStrings.length; i++) {
            if(excerciseStrings[i].startsWith("ДЗ: ")) {
                var excercise = new Exercise(excerciseStrings[i].substring(4),  0, Integer.valueOf(maximumStrings[i]));
                excercises.add(excercise);
            }
        }
        return excercises;
    }

    private static String[] transformNameData(String nameData) {
        var namesArr = nameData.split(" ");
        var resultNames = new String[2];
        resultNames[0] = namesArr[1];
        resultNames[1] = namesArr[0];
        if (namesArr.length > 2)
            for (int i = 2; i < namesArr.length; i++)
                resultNames[1] += namesArr[i];
        return resultNames;
    }

    private static void UpdateGradeToStudent(Student student, String[] humanString) {
        var subject = student.getCurrentSubjects().get(0);
        var themes = subject.getThemes();
        for(int i = 0; i < themes.stream().count(); i++) {
            var excercises = themes.get(i).getExercises();
            for (int j = 0; j < excercises.stream().count(); j++) {
                excercises.get(j).UpdateCurrentGrade(Double.valueOf(humanString[themeIndexes.get(i) + 1 + j]));
            }
            themes.get(i).UpdateGrade();
        }
        subject.UpdateGrade();
    }
}