import java.util.ArrayList;

public class Subject extends Discipline {
    private ArrayList<Chapter> chapters;

    public Subject(String title, ArrayList<Chapter> chapters) {
        super(title);
        this.chapters = chapters;
        UpdateGrade();
        UpdateEquivalentRating();
    }

    public Subject(Subject subject) {
        super(subject.getTitle());
        chapters = subject.getChapters();
        UpdateGrade();
        UpdateEquivalentRating();
    }

    public void UpdateGrade() {
        double currentGradeSum = 0;
        double maxGradeSum = 0;
        for (var chapter : chapters) {
            currentGradeSum += chapter.getCurrentOnlineLessonsGrade();
            maxGradeSum += chapter.getMaxOnlineLessonsGrade();
        }
        currentOnlineLessonsGrade = currentGradeSum;
        maxOnlineLessonsGrade = maxGradeSum;
     }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Subject(this.getTitle(), this.getChapters());
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
        return new String("    " + getTitle() + " (" + String.valueOf(getCurrentOnlineLessonsGrade()) + " / " + String.valueOf(getMaxOnlineLessonsGrade()) +") "
                + getEquivalentRating()  + ":" + "\n"  + (!getChapters().isEmpty() ? chaptersStringFormat : "    В данном предмете нет глав"));
    }
}