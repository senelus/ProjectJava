import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

abstract public class DataBaseWorker {

    public static void FillDataBases(String pathVerifiedStudents, String pathNotVerifiedStudents, ArrayList<Student> students) {
        var vStudents = "jdbc:sqlite:C:\\sqlite\\" + pathVerifiedStudents;
        var nvStudents = "jdbc:sqlite:C:\\sqlite\\" + pathNotVerifiedStudents;
        try (
                Connection verifiedStudentsConnection = DriverManager.getConnection(vStudents);
                Connection notVerifiedStudentsConnection = DriverManager.getConnection(nvStudents);
            )
        {
            if (verifiedStudentsConnection != null && notVerifiedStudentsConnection != null) {
                var statement1 = verifiedStudentsConnection.createStatement();
                var statement2 = notVerifiedStudentsConnection.createStatement();
                statement2.executeUpdate("DELETE FROM students;");
                statement1.executeUpdate("DELETE FROM students;");
                statement2.executeUpdate("DELETE FROM scores;");
                statement1.executeUpdate("DELETE FROM scores;");
                for (Student student : students) {
                    if (student.getId() == - 1) {
                        var query = "INSERT INTO students (first_name, last_name) " + "VALUES ("
                                + student.getFirst_name()  + "\", \""
                                + student.getLast_name()  + "\")";
                        statement2.executeUpdate(query);
                        var subject = student.getCurrentSubjects().get(0);
                        var themes = subject.getThemes();
                        query = "INSERT INTO scores (total_score, theme1_score, theme2_score, theme3_score, theme4_score, theme5_score, theme6_score, theme7_score, theme8_score, theme9_score, theme10_score, theme11_score, theme12_score, practic_score) VALUES ("
                                + themes.get(0).getCurrentOnlineLessonsGrade() + ", " + subject.getCurrentOnlineLessonsGrade()  + ", " + themes.get(1).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(2).getCurrentOnlineLessonsGrade() + ", " + themes.get(3).getCurrentOnlineLessonsGrade() + ", " + themes.get(4).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(5).getCurrentOnlineLessonsGrade() + ", " + themes.get(6).getCurrentOnlineLessonsGrade() + ", " + themes.get(7).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(8).getCurrentOnlineLessonsGrade() + ", " + themes.get(9).getCurrentOnlineLessonsGrade() + ", " + themes.get(10).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(11).getCurrentOnlineLessonsGrade() + ", " + themes.get(12).getCurrentOnlineLessonsGrade() + ")";
                        statement2.executeUpdate(query);

                    }
                    else {
                        var query = "INSERT INTO students (id, first_name, last_name ,sex, bdate, city, country, mobile_phone, photo_max_orig, faculty_name, university_name, education_form, site) " + "VALUES ("
                                + student.getId() + ", \""
                                + student.getFirst_name()  + "\", \""
                                + student.getLast_name()  + "\", "
                                + student.getSex()  + ", \""
                                + student.getBdate() + "\", \""
                                + ((student.getCity() != null) ? student.getCity().title : null ) + "\", \""
                                + ((student.getCountry() != null) ? student.getCountry().title : null )  + "\", \""
                                + student.getMobile_phone() + "\", \""
                                + student.getPhoto_max_orig() + "\", \""
                                + student.getFaculty_name() + "\", \""
                                + student.getUniversity_name() + "\", \""
                                + student.getEducation_form() + "\", \""
                                + student.getSite() + "\")";
                        statement1.executeUpdate(query);
                        var subject = student.getCurrentSubjects().get(0);
                        var themes = subject.getThemes();
                        query = "INSERT INTO scores (id ,total_score, theme1_score, theme2_score, theme3_score, theme4_score, theme5_score, theme6_score, theme7_score, theme8_score, theme9_score, theme10_score, theme11_score, theme12_score, practic_score) VALUES ("
                                + student.getId() + ", "
                                + themes.get(0).getCurrentOnlineLessonsGrade() + ", " + subject.getCurrentOnlineLessonsGrade()  + ", " + themes.get(1).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(2).getCurrentOnlineLessonsGrade() + ", " + themes.get(3).getCurrentOnlineLessonsGrade() + ", " + themes.get(4).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(5).getCurrentOnlineLessonsGrade() + ", " + themes.get(6).getCurrentOnlineLessonsGrade() + ", " + themes.get(7).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(8).getCurrentOnlineLessonsGrade() + ", " + themes.get(9).getCurrentOnlineLessonsGrade() + ", " + themes.get(10).getCurrentOnlineLessonsGrade() + ", "
                                + themes.get(11).getCurrentOnlineLessonsGrade() + ", " + themes.get(12).getCurrentOnlineLessonsGrade() + ")";
                        statement1.executeUpdate(query);
                    }
                }
                statement1.close();
                statement2.close();
                System.out.println("База успешно заполненна");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<ArrayList> GetAttributes(String path) {

        try (Connection connection = DriverManager.getConnection(path)) {
            var idArray = new ArrayList<Integer>();
            var first_nameArray = new ArrayList<String>();
            var last_nameArray = new ArrayList<String>();
            var sexArray = new ArrayList<Integer>();
            var bdateArray = new ArrayList<String>();
            var cityArray = new ArrayList<String>();
            var countryArray = new ArrayList<String>();
            var mobile_phoneArray = new ArrayList<String>();
            var photo_max_origArray = new ArrayList<String>();
            var faculty_nameArray = new ArrayList<String>();
            var university_nameArray = new ArrayList<String>();
            var education_formArray = new ArrayList<String>();
            var siteArray = new ArrayList<String>();
            var resultArray = new ArrayList<ArrayList>();
            var query = "SELECT * FROM students";
            var statement = connection.createStatement();
            var rs = statement.executeQuery(query);
            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t" +rs.getString("first_name") + "\t" + rs.getString("last_name") + "\t" + rs.getInt("sex") + "\t" + rs.getString("bdate")
//                        + "\t" + rs.getString("city") + "\t" + rs.getString("country") + "\t" + rs.getString("mobile_phone") + "\t" + rs.getString("photo_max_orig") + "\t"
//                        + rs.getString("faculty_name") + "\t "+ rs.getString("university_name") + "\t "+rs.getString("education_form") + "\t "+ rs.getString("site"));
                idArray.add(rs.getInt("id"));
                first_nameArray.add(rs.getString("first_name"));
                last_nameArray.add(rs.getString("last_name"));
                sexArray.add(rs.getInt("sex"));
                bdateArray.add(rs.getString("bdate"));
                cityArray.add(rs.getString("city"));
                countryArray.add(rs.getString("country"));
                mobile_phoneArray.add(rs.getString("mobile_phone"));
                photo_max_origArray.add(rs.getString("photo_max_orig"));
                faculty_nameArray.add(rs.getString("faculty_name"));
                university_nameArray.add(rs.getString("university_name"));
                education_formArray.add(rs.getString("education_form"));
                siteArray.add(rs.getString("site"));
            }
            rs.close();
            statement.close();
            resultArray.add(idArray);
            resultArray.add(first_nameArray);
            resultArray.add(last_nameArray);
            resultArray.add(sexArray);
            resultArray.add(bdateArray);
            resultArray.add(cityArray);
            resultArray.add(countryArray);
            resultArray.add(mobile_phoneArray);
            resultArray.add(photo_max_origArray);
            resultArray.add(faculty_nameArray);
            resultArray.add(university_nameArray);
            resultArray.add(education_formArray);
            resultArray.add(siteArray);
            return resultArray;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<Student> GetStudents(String path) {

        try (Connection connection = DriverManager.getConnection(path)) {
            var students = new ArrayList<Student>();
            var query = "SELECT * FROM students, scores";
            var statement = connection.createStatement();
            var rs = statement.executeQuery(query);
            while (rs.next()) {
                students.add(new Student(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("id"), rs.getString("bdate"), new City(0, rs.getString("city")),
                        rs.getString("mobile_phone"), rs.getString("photo_max_orig"), rs.getString("faculty_name"),
                        rs.getString("university_name"), rs.getString("education_form"), new Country(0, rs.getString("country")),
                        rs.getString("site"), rs.getInt("sex"), new ArrayList<Subject>(), new ArrayList<Subject>()));
            }
            rs.close();
            statement.close();
            return students;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
