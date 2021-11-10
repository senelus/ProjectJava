import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

   private static ArrayList<Integer> themeIndexes = new ArrayList<Integer>();
   private static ArrayList<Student> students = new ArrayList<Student>();

   public void parseCSVtoCourse(String path, String title) throws IOException{
      var csvParser = new CSVParserBuilder().withSeparator(';').build();
      var csvReader = new CSVReaderBuilder(new FileReader(path)).withCSVParser(csvParser).build();
      var themesString = csvReader.readNext().clone();
      var excercisesString = csvReader.readNext().clone();
      var maxValueSting = csvReader.readNext().clone();
      var themes = transformThemes(themesString, excercisesString, maxValueSting);
      try {
         String[] humanString;
         while (true) {
            var chapters = new ArrayList<Chapter>();
            chapters.add(new Chapter("", (ArrayList<Theme>) themes.clone()));
            var subjectArr = new ArrayList<Subject>();
            subjectArr.add(new Subject(title, chapters));
            humanString = csvReader.readNext();
            if (humanString[0].equals("")) break;
            var nameData = transformNameData(humanString[0]);
            var student = new Student(nameData[0], nameData[1], 19,null, null, null, null, subjectArr ,new ArrayList<Subject>());
            UpdateGradeToStudent(student,humanString);
            System.out.println(student);
            students.add(student);
         }
      }
      catch (NullPointerException e) {
         return;
      }

   }

   private ArrayList<Theme> transformThemes(String[] themeStings, String[] excerciseStrings, String[] maximumStrings) {
      var themes = new ArrayList<Theme>();
      for (int i = 0; i < themeStings.length; i++) {
         if(themeStings[i].equals("")) continue;
         themeIndexes.add(i);

      }
      for (int i = 0; i < themeIndexes.stream().count(); i++) {
         var subArrayExcercises = Arrays.copyOfRange(excerciseStrings, themeIndexes.get(i) + 1, (i == themeIndexes.stream().count() - 1 ? themeIndexes.get(i) + 2: themeIndexes.get(i + 1)));
         var subArrayMaximum = Arrays.copyOfRange(maximumStrings, themeIndexes.get(i) + 1, (i == themeIndexes.stream().count() - 1 ? themeIndexes.get(i) + 2 : themeIndexes.get(i + 1)));
         var excercises = transformExcercises(subArrayExcercises, subArrayMaximum);
         themes.add(new Theme(themeStings[themeIndexes.get(i)], excercises));
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
      var chapter = student.getCurrentSubjects().get(0).getChapters().get(0);
      var themes = chapter.getThemes();
      for(int i = 0; i < themes.stream().count(); i++) {
         var excercises = themes.get(i).getExercises();
         for (int j = 0; j < excercises.stream().count(); j++) {
            excercises.get(j).UpdateCurrentGrade(Double.valueOf(humanString[themeIndexes.get(i) + 1 + j]));
         }
         themes.get(i).UpdateGrade();
      }
      chapter.UpdateGrade();
      student.getCurrentSubjects().get(0).UpdateGrade();
   }

   public static ArrayList<Student> getStudents() {
      return students;
   }
}
