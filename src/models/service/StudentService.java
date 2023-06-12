package models.service;

import models.Student;
import models.enums.Gender;

import java.util.List;

public interface StudentService {
    Student updateStudent(String email, String newName, String newSurname, String newEmmail, String newPassword, Gender gender);

    Student getStudentByFirstName(String name);

    List<Student> getAllsudentsByGroupname(String name);
    String deleteStudentByEmail(String email);

}
