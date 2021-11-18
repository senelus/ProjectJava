public class Human {
    private String name;
    private String surname;
    private String birthdayDate;
    private int id;
    private String cityOfResidents;
    private String status;
    private String mobilePhoneNumber;
    private String homePhoneNumber;

    public Human(String name, String surname, int id , String birthdayDate, String cityOfResidents, String status, String mobilePhoneNumber, String homePhoneNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.birthdayDate = birthdayDate;
        this.cityOfResidents = cityOfResidents;
        this.status = status;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.homePhoneNumber = homePhoneNumber;
    }

    public Human(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public String getCityOfResidents() {
        return cityOfResidents;
    }

    public String getStatus() {
        return status;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    @Override
    public String toString() {
        return new String("Имя: " + getName() + "\n" + "Фамилия: " + getSurname() + "\n" + ((getBirthdayDate() != null) ? "Дата рождения: " + getBirthdayDate() + "\n" : "")
                + ((getCityOfResidents() != null) ? "Город проживания: " + getCityOfResidents() + "\n"  : "") +  ((getStatus() != null) ? "Статус: " + getStatus() + "\n"  : "")
                + ((getMobilePhoneNumber() != null) ?  "Мобильный телефон: " + getMobilePhoneNumber() + "\n" : "") +  ((getHomePhoneNumber() != null) ? "Домашний телефон: " + getHomePhoneNumber() + "\n" : ""));
    }
}