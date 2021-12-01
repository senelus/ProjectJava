public class Human {
    private String first_name;
    private String last_name;
    private String bdate;
    private int id;
    private City city;
    private Country country;
    private String mobile_phone;
    private String photo_max_orig;
    private String faculty_name;
    private String university_name;
    private String education_form;
    private String site;
    private int sex;

    public Human(String first_name, String last_name, int id , String bdate, String mobile_phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
        this.bdate = bdate;
        this.mobile_phone = mobile_phone;
    }

    public Human(String first_name, String last_name, int id , String bdate, City city, String mobile_phone, String photo_max_orig, String faculty_name, String university_name, String education_form, Country country, String site, int sex) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
        this.bdate = bdate;
        this.city = city;
        this.mobile_phone = mobile_phone;
        this.photo_max_orig = photo_max_orig;
        this.faculty_name = faculty_name;
        this.university_name = university_name;
        this.education_form = education_form;
        this.country = country;
        this.site = site;
        this.sex = sex;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getId() {
        return id;
    }

    public String getBdate() {
        return bdate;
    }

    public City getCity() {
        return city;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public String getEducation_form() { return education_form; }

    public String getFaculty_name() { return faculty_name; }

    public String getPhoto_max_orig() { return photo_max_orig; }

    public String getUniversity_name() { return university_name; }

    public Country getCountry() { return country; }

    public String getSite() { return site; }

    public int getSex() { return sex; }

    public String sexToString() {
        if (sex == 2) return "Мужской";
        if (sex == 1) return "Женский";
        return "Не указан";
    }

    @Override
    public String toString() {
        return "Фамилия: " + getLast_name() + "\n" + "Имя: " + getFirst_name() + "\n" + ((getId() != 0) ? "Id: " + getId() + "\n"  : "")
                + ((getBdate() != null && !getBdate().isEmpty()) ? "Дата рождения: " + getBdate() + "\n" : "") + "Пол: " + sexToString() + "\n"
                + ((getCountry() != null && !getCountry().title.isEmpty()) ? "Страна проживания: " + getCountry().title + "\n"  : "") + ((getCity() != null && !getCity().title.isEmpty()) ? "Город проживания: " + getCity().title + "\n"  : "")
                + ((getMobile_phone() != null && !getMobile_phone().isEmpty()) ?  "Мобильный телефон: " + getMobile_phone() + "\n" : "") + ((getUniversity_name() != null && !getUniversity_name().isEmpty()) ? "Университет: " + getUniversity_name() + "\n" : "")
                + ((getFaculty_name() != null && !getFaculty_name().isEmpty()) ?  "Институт: " + getFaculty_name() + "\n" : "") + ((getEducation_form() != null && !getEducation_form().isEmpty()) ? "Форма образования: " + getEducation_form() + "\n" : "")
                + ((getPhoto_max_orig() != null && !getPhoto_max_orig().isEmpty()) ?  "Фотография: " + getPhoto_max_orig() + "\n" : "") +  ((getSite() != null && !getSite().isEmpty()) ? "Сайт: " + getSite() + "\n" : "");
    }
}