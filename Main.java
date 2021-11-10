import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
//        Human human1 = new Human("Василий", "Тёркин", 31, "Москва", "Ни шагу назад!", "Школа № 1 ( 1933 - 1941)", "На войне");
//        System.out.println(human1.toString());
//        Student student = new Student("Александр", "Чех", 19, "Москва", "Всё сложно...", "Школа № 18 ( 2018 - 2020 )", "Временно безработный");
//        System.out.println(student.toString());
//        System.out.println("\n");
//        var excersice1 = new Exercise("1.1 Контрольные вопросы", 2, 2);
//        var excersice2 = new Exercise("1.2.2 Контрольные вопросы", 2, 2);
//        var excersice3 = new Exercise("1.2.3 Контрольный вопрос", 2, 2);
//        var excersice4 = new Exercise("1.2.4 Контрольный вопрос", 2, 2);
//        var excersice5 = new Exercise("1.2.5 Контрольный вопрос", 2, 2);
//        var excersice6 = new Exercise("1.3.2 Контрольный вопрос", 2, 2);
//        var excersices = new ArrayList<Exercise>();
//        excersices.add(excersice1);
//        excersices.add(excersice2);
//        excersices.add(excersice3);
//        excersices.add(excersice4);
//        excersices.add(excersice5);
//        excersices.add(excersice6);
//        Theme theme = new Theme("1.Введение в Java", excersices);
//        var themes = new ArrayList<Theme>();
//        themes.add(theme);
//        var chapter = new Chapter("Часть 1", themes);
//        var chapters = new ArrayList<Chapter>();
//        chapters.add(chapter);
//        var subject = new Subject("Java. Основы программирования на РТФ", chapters);
//        student.AddToCurrentSubjects(subject);
//        student.AddToInderbrednessSubjects(subject);
//        System.out.println(student.toString());
          Parser.parseCSVtoCourse("C:\\Users\\FleXx\\IdeaProjects\\JavaProject\\src\\java-rtf (5).csv", "Java курс");
    }
}