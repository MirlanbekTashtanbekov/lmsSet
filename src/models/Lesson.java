package models;

public class Lesson extends Group {
    private String lessonName;
    private String description;


    public Lesson() {
    }

    public Lesson(String lessonName, String description) {
        this.lessonName = lessonName;
        this.description = description;
    }



    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
