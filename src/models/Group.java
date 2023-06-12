package models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String nameOfGroup;
    private Long id;
    private String description;
    private List<Student>students=new ArrayList<>();
    private List<Lesson>lessons= new ArrayList<>();

    public Group(String nameOfGroup, Long id, String description, List<Student> students, List<Lesson> lessons) {
        this.nameOfGroup = nameOfGroup;
        this.id = id;
        this.description = description;
        this.students = students;
        this.lessons = lessons;
    }

    public Group(String nameOfGroup, String description) {
        this.nameOfGroup = nameOfGroup;
        this.id = id;
        this.description = description;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        StringBuilder sb = new StringBuilder();
        sb.append("\nGROUP:").append("\n")
                .append("NAME OF GROUP: ").append(nameOfGroup).append("\n")
                .append("ID: ").append(id).append("\n")
                .append("DESCRIPTION: ").append(description).append("\n")
                .append("LESSONS: ").append("\n").append(lessons).append("\n")
                .append("~~~~~~~~~~~~~~~~~~~~~~~").append("\n")
                .append("STUDENTS: ").append("\n").append(students).append("\n")
                .append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return sb.toString();
    }
}
