package models.service.impl;

import models.Group;
import models.Lesson;
import models.Student;
import models.database.DataBase;
import models.enums.Gender;
import models.exception.MyException;
import models.service.GroupService;

import java.util.List;

public class GroupServiceIMPL implements GroupService {
    private DataBase dataBase;
    private static Long groupId = 1l;
    private static Long studID = 1L;
    private static Long lessonID = 1L;

    public GroupServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;

    }


    @Override
    public List<Group> addNewGroup(Group group) {
        group.setId(groupId++);
        dataBase.getGroups().add(group);

        return dataBase.getGroups();
    }

    @Override
    public Group getGroupByName(String name) {
        Group foundGroup = null;
        try {
            boolean isFalse = false;
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                if (dataBase.getGroups().get(i).getNameOfGroup().equalsIgnoreCase(name)) {
                    isFalse = true;
                    foundGroup = dataBase.getGroups().get(i);
                    break;
                }
            }
            if (!isFalse) {
                throw new MyException("Мындай группа табылган жок");
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return foundGroup;
    }

    @Override
    public Group updateGroup(String name, String newName, String description) {
        Group updatedGroup = null;
        for (int i = 0; i < dataBase.getGroups().size(); i++) {
            try {
                if (dataBase.getGroups().get(i).getNameOfGroup().equalsIgnoreCase(name)) {
                    dataBase.getGroups().get(i).setNameOfGroup(newName);
                    dataBase.getGroups().get(i).setDescription(description);
                    updatedGroup = dataBase.getGroups().get(i);
                } else {
                    throw new MyException("Мындай аталышта группа табылган жок");
                }
                break;

            } catch (MyException m) {
                System.out.println(m.getMessage());
            }

        }
        return updatedGroup;
    }

    @Override
    public List<Group> getAllGroup() {
        return dataBase.getGroups();
    }

    @Override
    public List<Group> addNewStudentTiGroup(String groupName, String name, Long id, String surname, String email, String password, Gender gender) {
        try {
            for (Group group : dataBase.getGroups()) {
                if (group.getNameOfGroup().equalsIgnoreCase(groupName)) {
                    boolean emailExists = false;
                    for (Student student : dataBase.getStudents()) {
                        if (student.getEmail().equalsIgnoreCase(email)) {
                            emailExists = true;
                            break;
                        }
                    }
                    if (!emailExists) {
                        if (email.contains("@")){
                        group.getStudents().add(new Student(name, surname, studID++, email, password, gender));
                        return dataBase.getGroups();
                    } else {
                        throw new MyException("email @ символун камтышы керек!");
                    }
                    }else {
                        throw new MyException("Мындай почта катталган!");
                    }
                }
            }
            throw new MyException("Мындай группа табылган жок");
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }

        return null;
    }


    @Override
    public List<Group> addNewLessonToGroup(String groupName, String lessonName, Long id, String description) {
        try {
            boolean lessonExist = false;
            for (Lesson les : dataBase.getLessons()) {
                if (les.getName().equalsIgnoreCase(lessonName)) {
                    lessonExist = true;
                    break;
                }
            }
            if (lessonExist) {
                throw new MyException("Мындай сабак бар");
            }
            Lesson newLesson = new Lesson(lessonID++, lessonName, description);
            for (Group gr : dataBase.getGroups()) {
                if (gr.getNameOfGroup().equalsIgnoreCase(groupName)) {
                    gr.getLessons().add(newLesson);
                    for (Student stud : gr.getStudents()) {
                        stud.getLessons().add(newLesson);
                    }
                    return dataBase.getGroups();
                }

            }
            throw new MyException("Мындай группа табылган жок");
        } catch (MyException q) {
            System.out.println(q.getMessage());
        }
        return null;
    }

    @Override
    public List<Group> deleteGroup(String groupName) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                List<Group> groups = dataBase.getGroups();
                for (int j = 0; j < groups.size(); j++) {
                    if (groups.get(j).getNameOfGroup().equalsIgnoreCase(groupName)) {
                        groups.remove(j);
                        System.out.println(groupName + "  атындагы группа ийгиликтуу очурулду");
                        return groups;
                    }
                }
            }
            throw new MyException("Мындай группа табылган жок");

        } catch (MyException q) {
            System.out.println(q.getMessage());
        }
        return null;
    }
}






