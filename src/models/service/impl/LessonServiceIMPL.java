package models.service.impl;

import models.Group;
import models.Lesson;
import models.database.DataBase;
import models.exception.MyException;
import models.service.LessonService;
import models.Student;

import java.util.List;

public class LessonServiceIMPL implements LessonService {
    private DataBase dataBase;


    public LessonServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void getLessonByName(String name) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                List<Lesson> lessons = dataBase.getGroups().get(i).getLessons();
                for (int j = 0; j < lessons.size(); j++) {
                    if (lessons.get(j).getName().equalsIgnoreCase(name)) {
                        System.out.println(lessons.get(j));
                    } else throw new MyException("Мындай аталышта сабак жок");
                }
            }
        } catch (MyException q) {
            System.out.println(q.getMessage());
        }
    }

    @Override
    public List<Lesson> getAllLessonByGroupNAme(String name) {
        for (int i = 0; i < dataBase.getGroups().size(); i++) {
            try {
                if (dataBase.getGroups().get(i).getNameOfGroup().equalsIgnoreCase(name)) {
                    return dataBase.getGroups().get(i).getLessons();
                } else {
                    throw new MyException("Мындай группа табылган жок");
                }
            } catch (MyException q) {
                System.out.println(q.getMessage());
            }

        }
        return null;
    }

    @Override
    public List<Lesson> deleteLesson(String name) {
        for (int i = 0; i < dataBase.getGroups().size(); i++) {
            try {
                if (dataBase.getGroups().get(i).getLessons().get(i).getName().equalsIgnoreCase(name)) {
                    dataBase.getGroups().get(i).getLessons().remove(i);
                    System.out.println(name + " аталышындагы сабак ийгиликтуу очту!");
                } else {
                    throw new MyException("Мындай сабак табылган жок");
                }
            } catch (MyException q) {
                System.out.println(q.getMessage());
            }

        }
        return null;
    }

    @Override
    public List<Lesson> getAllStudentsLesson(String email) {
        try {
            for (Group group : dataBase.getGroups()) {
                for (Student student : group.getStudents()) {
                    if (student.getEmail().equalsIgnoreCase(email)) {
                       return student.getLessons();
                    } else throw new MyException("Мындай почта табылган жок");
                }

            }
        } catch (MyException q) {
            System.out.println(q.getMessage());
        }
        return null;
    }
}
