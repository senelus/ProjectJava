import java.util.ArrayList;

public class Student extends Human {
    private ArrayList<Subject> currentSubjects;
    private ArrayList<Subject> indebrednessSubjects;

    public Student(String name, String surname, int age, String cityOfResidents, String status, String education, String work) {
        super(name, surname, age, cityOfResidents, status, education, work);
        currentSubjects = new ArrayList<>();
        indebrednessSubjects = new ArrayList<>();
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

    public void setCurrentSubjects(ArrayList<Subject> currentSubjects) {
        this.currentSubjects = currentSubjects;
    }

    public void setIndebrednessSubjects(ArrayList<Subject> indebrednessSubjects) {
        this.indebrednessSubjects = indebrednessSubjects;
    }

    @Override
    public String toString() {
        return new String("Имя: " + getName() + "\n" + "Фамилия: " + getSurname() + "\n" + ((getAge() != 0) ? "Возраст: " + getAge() + "\n" : "")
                + ((getCityOfResidents() != null) ? "Город проживания: " + getCityOfResidents() + "\n"  : "") +  ((getStatus() != null) ? "Статус: " + getStatus() + "\n"  : "")
                + ((getEducation() != null) ?  "Образование: " + getEducation() + "\n" : "") +  ((getWork() != null) ? "Место работы: " + getWork() + "\n" : "")
                + ((!getCurrentSubjects().isEmpty()) ? )

        );
    }
}
