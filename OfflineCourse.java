import java.util.ArrayList;

public class OfflineCourse extends Subject {
    private ArrayList<PracticalLesson> practicalLessons;
    private double currentPracticalLessonsGrade;
    private double maxPracticalLessonsGrade;
    private double onlineFactor;
    private double practicalFactor;

    public OfflineCourse(String title, ArrayList<Chapter> chapters, ArrayList<PracticalLesson> practicalLessons, double onlineFactor, double practicalFactor) {
        super(title, chapters);
        this.practicalLessons = practicalLessons;
        this.onlineFactor = onlineFactor;
        this.practicalFactor = practicalFactor;
    }

    public ArrayList<PracticalLesson> getPracticalLessons() {
        return practicalLessons;
    }

    public double getCurrentPracticalLessonsGrade() {
        return currentPracticalLessonsGrade;
    }

    public double getMaxPracticalLessonsGrade() {
        return maxPracticalLessonsGrade;
    }

    @Override
    public void UpdateGrade() {
        double currentGradeSum = 0;
        double maxGradeSum = 0;
        double currentPracticalLessonsGradeSum = 0;
        double maxPracticalLessonsGradeSum = 0;
        for (var chapter : getChapters()) {
            currentGradeSum += chapter.getCurrentOnlineLessonsGrade();
            maxGradeSum += chapter.getMaxOnlineLessonsGrade();
        }
        for (var practicalLesson : practicalLessons) {
            currentPracticalLessonsGradeSum += practicalLesson.currentOnlineLessonsGrade;
            maxPracticalLessonsGradeSum += practicalLesson.maxOnlineLessonsGrade;
        }
        currentOnlineLessonsGrade = currentGradeSum;
        maxOnlineLessonsGrade = maxGradeSum;
        currentPracticalLessonsGrade = currentPracticalLessonsGradeSum;
        maxPracticalLessonsGrade = maxPracticalLessonsGradeSum;
    }

    @Override
    public void UpdateEquivalentRating() {
        double ratio = ((getCurrentOnlineLessonsGrade() / getMaxOnlineLessonsGrade()) * onlineFactor) + (getCurrentPracticalLessonsGrade() / getCurrentPracticalLessonsGrade() * practicalFactor);
        if (ratio >= 0.8) equivalentRating = "Отлично";
        else if (ratio >= 0.6) equivalentRating = "Хорошо";
        else if (ratio >= 0.4) equivalentRating = "Удолетворительно";
        else equivalentRating = "Неудолетворительно";
    }

    @Override
    public String toString() {
        UpdateGrade();
        UpdateEquivalentRating();
        var chaptersStringFormat = "";
        for (int i = 0; i < getChapters().stream().count(); i++) {
            chaptersStringFormat += getChapters().get(i).toString();
            if (i < getChapters().stream().count() - 1) chaptersStringFormat += "\n";
        }
        var practicalLessonsStringFormat = "";
        for (int i = 0; i < getPracticalLessons().stream().count(); i++) {
            practicalLessonsStringFormat += getPracticalLessons().get(i).toString();
            if (i < getChapters().stream().count() - 1) practicalLessonsStringFormat += "\n";
        }
        return new String("    " + getTitle() + "Баллы за онлайн: (" + String.valueOf(getCurrentOnlineLessonsGrade()) + " / " + String.valueOf(getMaxOnlineLessonsGrade()) +") "
                + "Баллы за практики: (" + String.valueOf(getCurrentPracticalLessonsGrade()) + " / " + String.valueOf(getMaxPracticalLessonsGrade()) +") "
                + getEquivalentRating() + ":" + "\n"  + (!getChapters().isEmpty() ? chaptersStringFormat : "    В данном предмете нет глав")
                + "\n"  + (!getPracticalLessons().isEmpty() ? practicalLessonsStringFormat : "    В данном предмете нет текущих практик")
        );
    }

}