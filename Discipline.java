public abstract class Discipline {
    private String title;
    protected double currentOnlineLessonsGrade;
    protected double maxOnlineLessonsGrade;
    protected String equivalentRating= "Неудолетворительно";

    public Discipline(String title) {
        this.title = title;
    }

    public Discipline(String title, double currentGrade, double maxGrade) {
        this.title = title;
        this.currentOnlineLessonsGrade = currentGrade;
        this.maxOnlineLessonsGrade = maxGrade;
    }

    public Discipline(String title, double currentGrade) {
        this.title = title;
        this.currentOnlineLessonsGrade = currentGrade;
        this.maxOnlineLessonsGrade = Double.POSITIVE_INFINITY;
    }

    public String getTitle() {
        return title;
    }

    public double getCurrentOnlineLessonsGrade() {
        return currentOnlineLessonsGrade;
    }

    public double getMaxOnlineLessonsGrade() {
        return maxOnlineLessonsGrade;
    }

    public String getEquivalentRating() {
        return equivalentRating;
    }

    public void UpdateEquivalentRating() {
        double ratio = (getCurrentOnlineLessonsGrade() / getMaxOnlineLessonsGrade());
        if (ratio >= 0.8) equivalentRating = "Отлично";
        else if (ratio >= 0.6) equivalentRating = "Хорошо";
        else if (ratio >= 0.4) equivalentRating = "Удолетворительно";
        else equivalentRating = "Неудолетворительно";
    }

}
