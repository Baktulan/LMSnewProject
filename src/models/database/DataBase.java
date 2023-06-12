package models.database;

import models.Group;
import models.Lesson;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Group>groups= new ArrayList<>();
    private List<Student>students= new ArrayList<>();
    private List<Lesson>lessons= new ArrayList<>();
    private static Long grouCounter=1L;
    private static Long studCounter=1L;
    private static Long lessonCounter=1L;

    public DataBase(List<Group> groups, List<Student> students, List<Lesson> lessons) {
        this.groups = groups;
        this.students = students;
        this.lessons = lessons;
    }



    public static Long getGrouCounter() {
        return grouCounter;
    }

    public static void setGrouCounter(Long grouCounter) {
        DataBase.grouCounter = grouCounter;
    }

    public static Long getLessonCounter() {
        return lessonCounter;
    }

    public static void setLessonCounter(Long lessonCounter) {
        DataBase.lessonCounter = lessonCounter;
    }

    public DataBase() {
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
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
}
