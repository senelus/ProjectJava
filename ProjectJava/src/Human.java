public class Human {
    private String name;
    private String surname;
    private int age;
    private String cityOfResidents;
    private String status;
    private String education;
    private String work;

    public Human(String name, String surname, int age, String cityOfResidents, String status, String education, String work) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cityOfResidents = cityOfResidents;
        this.status = status;
        this.education = education;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCityOfResidents() {
        return cityOfResidents;
    }

    public String getStatus() {
        return status;
    }

    public String getEducation() {
        return education;
    }

    public String getWork() {
        return work;
    }

    @Override
    public String toString() {
        return new String("Имя: " + getName() + "\n" + "Фамилия: " + getSurname() + "\n" + ((getAge() != 0) ? "Возраст: " + getAge() + "\n" : "")
                + ((getCityOfResidents() != null) ? "Город проживания: " + getCityOfResidents() + "\n"  : "") +  ((getStatus() != null) ? "Статус: " + getStatus() + "\n"  : "")
                + ((getEducation() != null) ?  "Образование: " + getEducation() + "\n" : "") +  ((getWork() != null) ? "Место работы: " + getWork() + "\n" : ""));
    }
}
