import java.util.ArrayList;

public class Chapter extends Discipline {
    private ArrayList<Theme>  themes;

    public Chapter(String title, ArrayList<Theme> themes) {
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
        var themesStringFormat = "";
        for (int i = 0; i < getThemes().stream().count(); i++) {
            themesStringFormat += getThemes().get(i).toString();
            if (i < getThemes().stream().count() - 1) themesStringFormat += "\n";
        }
        return new String("        " + getTitle() + " (" + String.valueOf(getCurrentOnlineLessonsGrade()) + " / " + String.valueOf(getMaxOnlineLessonsGrade()) +") " + getEquivalentRating() + ":"
                + "\n"  + (!getThemes().isEmpty() ? themesStringFormat : "        В данной главе нет тем"));
    }
}
