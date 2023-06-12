package models.service;

import models.Lesson;

import java.util.List;

public interface LessonService {
    void getLessonByName(String name);
    List<Lesson>getAllLessonByGroupNAme(String name);

    List<Lesson>deleteLesson(String name);
    List<Lesson>getAllStudentsLesson(String email);
}
