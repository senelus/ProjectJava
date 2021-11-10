import java.util.ArrayList;

public class Theme extends Discipline {
    private ArrayList<Exercise> exercises;

    public Theme(String title, ArrayList<Exercise> exercises) {
        super(title);
        this.exercises = exercises;
        UpdateGrade();
        UpdateEquivalentRating();
    }

    public void UpdateGrade() {
        double currentGradeSum = 0;
        double maxGradeSum = 0;
        for (var exercise : exercises) {
            currentGradeSum += exercise.getCurrentOnlineLessonsGrade();
            maxGradeSum += exercise.getMaxOnlineLessonsGrade();
        }
        currentOnlineLessonsGrade = currentGradeSum;
        maxOnlineLessonsGrade = maxGradeSum;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
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
        return new String("            " + getTitle() + " (" + String.valueOf(getCurrentOnlineLessonsGrade()) + " / " + String.valueOf(getMaxOnlineLessonsGrade()) +") " + getEquivalentRating() + ":"
                + "\n"  + (!getExercises().isEmpty() ? "                Задания:\n" + exercisesStringFormat : "                В данной теме нет заданий"));
    }
}
