package models.service;

import models.Group;
import models.enums.Gender;

import java.util.List;

public interface GroupService {

    List<Group> addNewGroup(Group group);

    Group getGroupByName(String name);
    Group updateGroup(String name, String newName,String description);
    List<Group> getAllGroup();
    List<Group>addNewStudentTiGroup(String groupName,String name,Long id, String surname, String email, String password, Gender gender);
    List<Group>addNewLessonToGroup(String groupName,String lessonName,Long id,String description);
    List<Group>deleteGroup(String groupName);
}
