import java.util.ArrayList;

public class Subject extends Discipline {
    private ArrayList<Theme> themes;

    public Subject(String title, ArrayList<Theme> themes) {
        super(title);
        this.themes = themes;
        UpdateGrade();
        UpdateEquivalentRating();
    }

    public void UpdateGrade() {
        double currentGradeSum = 0;
        double maxGradeSum = 0;
        for (var theme : themes) {
            currentGradeSum += theme.getCurrentOnlineLessonsGrade();
            maxGradeSum += theme.getMaxOnlineLessonsGrade();
        }
        currentOnlineLessonsGrade = currentGradeSum;
        maxOnlineLessonsGrade = maxGradeSum;
    }

    public ArrayList<Theme> getThemes() {
        return themes;
    }

    @Override
    public String toString() {
        UpdateGrade();
        UpdateEquivalentRating();
        var chaptersStringFormat = "";
        for (int i = 0; i < getThemes().stream().count(); i++) {
            chaptersStringFormat += getThemes().get(i).toString();
            if (i < getThemes().stream().count() - 1) chaptersStringFormat += "\n";
        }
        return new String("    " + getTitle() + " (" + String.valueOf(getCurrentOnlineLessonsGrade()) + " / " + String.valueOf(getMaxOnlineLessonsGrade()) +") "
                + getEquivalentRating()  + ":" + "\n"  + (!getThemes().isEmpty() ? chaptersStringFormat : "    В данном предмете нет глав"));
    }
}