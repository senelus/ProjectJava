import java.util.ArrayList;

public class Student extends Human {
    private ArrayList<Subject> currentSubjects;
    private ArrayList<Subject> indebrednessSubjects;

    public Student(String first_name, String last_name, int id , String bdate, City city, String mobile_phone, String photo_max_orig, String faculty_name, String university_name, String education_form, Country country, String site, int sex, ArrayList<Subject> currentSubjects, ArrayList<Subject> indebrednessSubjects) {
        super(first_name, last_name, id, bdate, city, mobile_phone, photo_max_orig, faculty_name, university_name, education_form, country, site, sex);
        this.currentSubjects = currentSubjects;
        this.indebrednessSubjects = indebrednessSubjects;
    }

    public Student(String name, String surname, ArrayList<Subject> currentSubjects,  ArrayList<Subject> indebrednessSubjects) {
        super(name, surname, -1, null, null);
        this.currentSubjects = currentSubjects;
        this.indebrednessSubjects = indebrednessSubjects;
    }


    public ArrayList<Subject> getCurrentSubjects() {
        return currentSubjects;
    }

    public ArrayList<Subject> getIndebrednessSubjects() {
        return indebrednessSubjects;
    }

    public void AddToCurrentSubjects(Subject subject) {
        currentSubjects.add(subject);
    }

    public void AddToInderbrednessSubjects(Subject subject) {
        indebrednessSubjects.add(subject);
    }


    @Override
    public String toString() {
        var subjectsStringFormat = "";
        var indebrednessSubjectsStringFormat = "";
        var currentSubjects = getCurrentSubjects();
        var indebrednessSubjects = getIndebrednessSubjects();
        for (int i = 0; i < currentSubjects.stream().count(); i++) {
            subjectsStringFormat += currentSubjects.get(i).toString();
            if (i < currentSubjects.stream().count() - 1) subjectsStringFormat += "\n";
        }
        for (int i = 0; i < indebrednessSubjects.stream().count(); i++) {
            indebrednessSubjectsStringFormat += indebrednessSubjects.get(i).toString();
            if (i < indebrednessSubjects.stream().count() - 1) indebrednessSubjectsStringFormat += "\n";
        }
        return "Фамилия: " + getLast_name() + "\n" + "Имя: " + getFirst_name() + "\n" + ((getId() != 0) ? "Id: " + getId() + "\n"  : "")
                + ((getBdate() != null && !getBdate().isEmpty()) ? "Дата рождения: " + getBdate() + "\n" : "") + "Пол: " + sexToString() + "\n"
                + ((getCountry() != null && !getCountry().title.isEmpty()) ? "Страна проживания: " + getCountry().title + "\n"  : "") + ((getCity() != null && !getCity().title.isEmpty()) ? "Город проживания: " + getCity().title + "\n"  : "")
                + ((getMobile_phone() != null && !getMobile_phone().isEmpty()) ?  "Мобильный телефон: " + getMobile_phone() + "\n" : "") + ((getUniversity_name() != null && !getUniversity_name().isEmpty()) ? "Университет: " + getUniversity_name() + "\n" : "")
                + ((getFaculty_name() != null && !getFaculty_name().isEmpty()) ?  "Институт: " + getFaculty_name() + "\n" : "") + ((getEducation_form() != null && !getEducation_form().isEmpty()) ? "Форма образования: " + getEducation_form() + "\n" : "")
                + ((getPhoto_max_orig() != null && !getPhoto_max_orig().isEmpty()) ?  "Фотография: " + getPhoto_max_orig() + "\n" : "") +  ((getSite() != null && !getSite().isEmpty()) ? "Сайт: " + getSite() + "\n" : "")
                + ((!getCurrentSubjects().isEmpty()) ? "Текущие предметы:\n" + subjectsStringFormat + "\n" : "Нет текущих предметов \n")
                + ((!getIndebrednessSubjects().isEmpty() ? "Долги:\n"  + indebrednessSubjectsStringFormat + "\n" : "Нет текущих долгов по предметам " ));
    }
}