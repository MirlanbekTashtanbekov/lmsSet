package models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long id;
    private String name;
    private String description;
    private List<Student> students = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();

    public Group() {
    }

    public Group(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description=description;
    }

    public Group(Long id, String name, String description, List<Student> students, List<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = students;
        this.lessons = lessons;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }


    @Override
    public String toString() {
        return "\nGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
