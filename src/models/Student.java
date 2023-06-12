package models;

import models.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private Long id;
    private String email;
    private String password;
    private List<Lesson>lessons=new ArrayList<>();
    private Gender gender;


    public Student(String name, String surname, Long studId, String email, String password, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.id=studId;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSTUDENT NAME: ").append(name).append("\n")
                .append("SURNAME: ").append(surname).append("\n")
                .append("ID: ").append(id).append("\n")
                .append("EMAIL: ").append(email).append("\n")
                .append("PASSWORD: ").append(password).append("\n")
                .append("LESSONS: ").append(lessons).append("\n")
                .append("GENDER: ").append(gender).append("\n")
                .append("~~~~~~~~~~~~~~~~~~~~~");
        return sb.toString();
    }

}
