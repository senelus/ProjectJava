import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var parser = new Parser();
        parser.parseCSVtoCourse("C:\\Users\\FleXx\\IdeaProjects\\JavaProject\\src\\java-rtf (5).csv", "Java курс");
    }
}