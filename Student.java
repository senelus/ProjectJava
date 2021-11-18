import java.util.ArrayList;

public class Student extends Human {
    private ArrayList<Subject> currentSubjects;
    private ArrayList<Subject> indebrednessSubjects;

    public Student(String name, String surname, int id, String birthday, String cityOfResidents, String status, String mobilePhoneNumber, String homePhoneNumber, ArrayList<Subject> currentSubjects, ArrayList<Subject> indebrednessSubjects) {
        super(name, surname, id, birthday, cityOfResidents, status, mobilePhoneNumber, homePhoneNumber);
        this.currentSubjects = currentSubjects;
        this.indebrednessSubjects = indebrednessSubjects;
    }

    public Student(String name, String surname, ArrayList<Subject> currentSubjects,  ArrayList<Subject> indebrednessSubjects) {
        super(name, surname, -1, null, null, null, null, null);
        this.currentSubjects = currentSubjects;
        this.indebrednessSubjects = indebrednessSubjects;
    }

    public Student(String name, String surname, int id,ArrayList<Subject> currentSubjects,  ArrayList<Subject> indebrednessSubjects) {
        super(name, surname, id, null, null, null, null, null);
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
        return new String("Имя: " + getName() + "\n" + "Фамилия: " + getSurname() + "\n" + ((getBirthdayDate() != null) ? "День рождения: " + getBirthdayDate() + "\n" : "")
                + ((getCityOfResidents() != null) ? "Город проживания: " + getCityOfResidents() + "\n"  : "") +  ((getStatus() != null) ? "Статус: " + getStatus() + "\n"  : "")
                + ((getMobilePhoneNumber() != null) ?  "Мобильный телефон: " + getMobilePhoneNumber() + "\n" : "") +  ((getHomePhoneNumber() != null) ? "Домашний телефон: " + getHomePhoneNumber() + "\n" : "")
                + ((!getCurrentSubjects().isEmpty()) ? "Текущие предметы:\n" + subjectsStringFormat + "\n" : "Нет текущих предметов \n")
                + ((!getIndebrednessSubjects().isEmpty() ? "Долги:\n"  + indebrednessSubjectsStringFormat + "\n" : "Нет текущих долгов по предметам " ))
        );
    }
}