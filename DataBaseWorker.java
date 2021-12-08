import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

abstract public class DataBaseWorker {

    public static void fillDataBase(String pathToDataBase, ArrayList<Student> students) {
        var path = "jdbc:sqlite:C:\\sqlite\\" + pathToDataBase;
        try (Connection connection = DriverManager.getConnection(path)) {
            if (connection != null) {
                for (var student : students) {

                }
                var query = "INSERT INTO students (id, first_name, last_name ,sex, bdate, city, country, mobile_phone, photo_max_orig, faculty_name, university_name, education_form, site) VALUES (123, \"Vasya\", \"Pypkin\", \"1\", \"30/12/2021\", \"Екатеринбург\", \"Россия\", \"+791221\", \"hsghsghsg\", \"Пофиг\", \"Пофиг\", \"Пофиг\", \"Пофиг\")";
                var statement = connection.createStatement();
                statement.executeUpdate(query);
                System.out.println("GG");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
