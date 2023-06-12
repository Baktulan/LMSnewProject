package models.service.impl;

import models.Group;
import models.Student;
import models.database.DataBase;
import models.enums.Gender;
import models.exception.MyException;
import models.service.StudentService;

import java.util.List;

public class StudentServiceIMPL implements StudentService {
    private DataBase dataBase;

    public StudentServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Student updateStudent(String email, String newName, String newSurname, String newEmmail, String newPassword, Gender gender) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                for (int j = 0; j <dataBase.getGroups().get(i).getStudents().size() ; j++) {
                    if (dataBase.getGroups().get(i).getStudents().get(j).getEmail().equalsIgnoreCase(email)&&newEmmail.contains("@")) {
                        dataBase.getGroups().get(i).getStudents().get(j).setName(newName);
                        dataBase.getGroups().get(i).getStudents().get(j).setSurname(newSurname);
                        dataBase.getGroups().get(i).getStudents().get(j).setEmail(newEmmail);
                        dataBase.getGroups().get(i).getStudents().get(j).setPassword(newPassword);
                        return dataBase.getGroups().get(i).getStudents().get(j);
                    }else {
                        throw new MyException(" Логин @ символун камтышы керек ");
                    }

                }
            }
            throw new MyException("Пароль же Логин туура эмес");
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }

        return null;
    }

    @Override
    public Student getStudentByFirstName(String name) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                boolean found = false;
                Group group = dataBase.getGroups().get(i);
                if (group.getStudents().get(i).getName().equalsIgnoreCase(name)) {
                    found = true;
                    return group.getStudents().get(i);
                } else throw new MyException("Мындай студент жок");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> getAllsudentsByGroupname(String name) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                boolean full = false;
                List<Group> groups = dataBase.getGroups();
                for (int j = 0; j < groups.size(); j++) {
                    if (groups.get(i).getStudents() != null) {
                        full = true;
                        if (groups.get(j).getNameOfGroup().equalsIgnoreCase(name)) {
                            return groups.get(j).getStudents();
                        } else throw new MyException("Мындай аталышта группа табылган жок");

                    }
                    if (!full) {
                        throw new MyException("Бул группада студенттер жок");
                    }
                }
            }
        } catch (MyException q) {
            System.out.println(q.getMessage());
        }
        return null;
    }

    @Override
    public String deleteStudentByEmail(String email) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                List<Student> students = dataBase.getGroups().get(i).getStudents();
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).getEmail().equalsIgnoreCase(email)&&email.contains("@")) {
                        students.remove(j);
                        return email + " aтындагы почта ийгиликтуу очурулду";
                    }else {
                        throw new MyException(" Логин @ символун камтышы керек");
                    }
                }
            }
            throw new MyException("Мындай почта табылган жок");
        } catch (MyException q) {
            System.out.println(q.getMessage());
        }
        return "";
    }
}

