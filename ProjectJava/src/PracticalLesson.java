import java.util.ArrayList;
import java.util.Date;

public class PracticalLesson extends Theme{
    private Date date;

    public PracticalLesson(String title, ArrayList<Exercise> exercises, Date date) {
        super(title, exercises);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        UpdateGrade();
        UpdateEquivalentRating();
        var exercisesStringFormat = "";
        for (int i = 0; i < getExercises().stream().count(); i++) {
            exercisesStringFormat += getExercises().get(i).toString();
            if (i < getExercises().stream().count() - 1) exercisesStringFormat += "\n";
        }
        return new String("            " + getTitle() + " " + getDate().toString() + " (" + String.valueOf(getCurrentOnlineLessonsGrade()) + " / " + String.valueOf(getMaxOnlineLessonsGrade()) +") " + getEquivalentRating() + ":"
                + "\n"  + (!getExercises().isEmpty() ? "                Задания:\n" + exercisesStringFormat : "                В данной теме нет заданий"));
    }
}
