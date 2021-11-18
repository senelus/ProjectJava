

public class Exercise extends Discipline {

    public Exercise(String title, double currentGrade, double maxGrade) {
        super(title, currentGrade, maxGrade);
    }

    public Exercise(String title, double currentGrade) {
        super(title, currentGrade);
    }

    public void UpdateCurrentGrade(double currentGrade) {
        this.currentOnlineLessonsGrade = currentGrade;
    }

    protected Exercise clone() {
        return new Exercise(this.getTitle(), this.currentOnlineLessonsGrade, this.maxOnlineLessonsGrade);
    }


    @Override
    public String toString() {
        return new String("                    " + getTitle() + ":"  + "\n" +  "                        " +  "Текущая оценка: " + String.valueOf(getCurrentOnlineLessonsGrade()) + (getMaxOnlineLessonsGrade() != Double.POSITIVE_INFINITY ?  " / " + String.valueOf(getMaxOnlineLessonsGrade()) : ""));
    }
}