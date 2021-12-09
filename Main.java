public class Main {
    public static void main(String[] args) throws Exception {
        var token = "3c5ee5d0169dbfef5223a5d19a3fcdddbf694afecf4e5737b4676bd81196318bc13698c7fdd95235192a4";
        var APIversion = "5.103";
        var groupId = "198188261";
        var pathToCSV = "C:\\Users\\FleXx\\IdeaProjects\\JavaProject\\src\\java-rtf (5).csv";
        var courseTitle = "Java курс";
        var studentsData = Parser.createStudentData(pathToCSV, courseTitle, token, APIversion, groupId);
        //System.out.println(studentsData);
        DataBaseWorker.FillDataBases("vT.db", "nvT.db", studentsData);
        //System.out.println(studentsData);
        System.out.println(DataBaseWorker.GetAttributes("jdbc:sqlite:C:\\sqlite\\nvT.db"));
        System.out.println(DataBaseWorker.GetAttributes("jdbc:sqlite:C:\\sqlite\\vT.db"));
        //System.out.println(DataBaseWorker.GetStudents("jdbc:sqlite:C:\\sqlite\\vT.db"));
        //System.out.println(attr);
    }
}