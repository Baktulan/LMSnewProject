import models.Group;
import models.admin.Admin;
import models.database.DataBase;
import models.enums.Gender;
import models.service.impl.GroupServiceIMPL;
import models.service.impl.LessonServiceIMPL;
import models.service.impl.StudentServiceIMPL;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        GroupServiceIMPL groupServiceIMPL = new GroupServiceIMPL(dataBase);
        StudentServiceIMPL studentServiceIMPL = new StudentServiceIMPL(dataBase);
        LessonServiceIMPL lessonServiceIMPL = new LessonServiceIMPL(dataBase);

        Scanner scanner0 = new Scanner(System.in);
        Scanner scanner01 = new Scanner(System.in);
        int num1;
        Admin admin = new Admin("baku@mail.ru","baku1234");
        while (true) {
            LocalDate data = LocalDate.now();
            LocalTime currentTime = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.MINUTES);
            if (currentTime.isBefore(LocalTime.NOON)) {
                System.out.println("Кутман тан!");
            } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
                System.out.println("Кутман кун!");
            } else {
                System.out.println("Кутман кеч!");
            }
            System.out.println(data + " Саат-" + currentTime);
            System.out.println("Катталган болсонуз 1 ди басыныз, пароль унутуп калып озгортуу учун 2 ни басыныз");

            num1 = scanner0.nextInt();
            switch (num1) {

                case 1 :
                    System.out.print("логин жазыныз:");
                    String email = scanner01.nextLine();
                    System.out.print("пароль жазыныз:");
                    String password = scanner01.nextLine();
                    admin.setEmail(email);
                    if (email.equalsIgnoreCase("baku@mail.ru") && password.equalsIgnoreCase(admin.getPassword())) {
                        admin.setPassword(admin.getPassword()) ;

                        System.out.println("Кош келиниз!!!");
                        System.out.println(admin.toString());
                        menu();

                    }else {
                        System.out.println("Пароль же логин туура эмес");
                    }

                    break;

                case 2 : {
                    System.out.print("Паролду озгортуу учун логинди жазыныз: ");
                    String log = scanner01.nextLine();
                    System.out.print("Жаны пароль жазыныз: ");
                    String pass = scanner01.nextLine();
                    admin.setPassword(admin.getPassword());

                    if(admin.getEmail().equalsIgnoreCase(log)){
                        if (pass.length()>8){
                            admin.setPassword(pass);
                            System.out.println("Пароль ийгиликтуу озгорду!");
                        }else {
                            System.out.println("Паролдун узундугу 8 символдон кем болбоосу керек!");
                        }


                    }else {
                        System.out.println("Логин туура эмес");
                    }
                    System.out.println(admin.toString());

                    break;
                }
            }
        }}
    public static void menu() {
        DataBase dataBase = new DataBase();
        GroupServiceIMPL groupServiceIMPL = new GroupServiceIMPL(dataBase);
        StudentServiceIMPL studentServiceIMPL = new StudentServiceIMPL(dataBase);
        LessonServiceIMPL lessonServiceIMPL = new LessonServiceIMPL(dataBase);
        Scanner scanner = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);
        int num;
        while (true) {
            System.out.println("""
                     ____________________________________________________________________
                    | 1.Add new Group                 | 8.Get all students by group name|
                    | 2.Get Group by name             | 9.Get all student's lesson      |
                    | 3.Update group name             | 10.Delete student               |
                    | 4.Get all groups                | 11.Add new lesson to group      |
                    | 5.Add new student to group      | 12.Get lesson by name           |
                    | 6.Update student                | 13.Get all lesson by group name |
                    | 7.Find student by first name    | 14.Delete Lesson                |
                    |                                 | 15.Delete Group                 |
                    |___________________________________________________________________|

                     """);
            num = scannerNum.nextInt();
            switch (num) {
                case 1: {
                    System.out.print("Группанын атын жазыныз: ");
                    String newGroup = scanner.nextLine();
                    System.out.print("Группа жонундо жазыныз: ");
                    String description = scanner.nextLine();
                    System.out.println(groupServiceIMPL.addNewGroup(new Group(newGroup, description)));
                    break;

                }
                case 2: {
                    System.out.print("Издеген группаныздын атын жазыныз: ");
                    String search = scanner.nextLine();
                    System.out.println(groupServiceIMPL.getGroupByName(search));
                    break;
                }
                case 3: {
                    System.out.print("Озгортуло турган группанын атын жазынызын: ");
                    String updateOldGroup = scanner.nextLine();
                    System.out.print("Жаны ат жызыныз: ");
                    String newUpdatedGroup = scanner.nextLine();
                    System.out.print("Жаны группага суроттомо жазыныз: ");
                    String newDescription = scanner.nextLine();
                    System.out.println(groupServiceIMPL.updateGroup(updateOldGroup, newUpdatedGroup, newDescription));
                    break;
                }
                case 4: {
                    System.out.println(groupServiceIMPL.getAllGroup());
                    break;
                }
                case 5: {
                    System.out.print("Студентти кошо турган группанын атын жазыныз: ");
                    String groupName = scanner.nextLine();
                    System.out.print("Студенттин атын жазыныз: ");
                    String studName = scanner.nextLine();
                    System.out.print("Студенттин фамилясын жазыныз: ");
                    String surName = scanner.nextLine();
                    System.out.print("Студенттин почтасын жазыныз: ");
                    String email = scanner.nextLine();
                    System.out.print("Пароль жазыныз: ");
                    String password = scanner.nextLine();
                    System.out.print("Жынысын жазыныз MALE / FEMALE: ");
                    String gendeer = scanner.nextLine().toUpperCase();
                    Gender gender = Gender.valueOf(gendeer);
                    List<Group> groups = groupServiceIMPL.addNewStudentTiGroup(groupName, studName, null, surName, email, password, gender);
                    System.out.println(groups);
                    break;

                }
                case 6: {
                    System.out.print("Озгортулуучу адамдын email нин жазыныз: ");
                    String oldEmail = scanner.nextLine();
                    System.out.print("Жаны ат жазыныз: ");
                    String newName = scanner.nextLine();
                    System.out.print("Фамиля жазыныз: ");
                    String newsurname = scanner.nextLine();
                    System.out.print("Жаны email жазыныз: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Пароль жазыныз: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Жынысын жазыныз MALE / FEMALE: ");
                    String gendeer = scanner.nextLine().toUpperCase();
                    Gender gender = Gender.valueOf(gendeer);
                    System.out.println(studentServiceIMPL.updateStudent(oldEmail, newName, newsurname, newEmail, newPassword,gender ));
                    break;

                }
                case 7: {
                    System.out.print("Студенттин атын жазыныз: ");
                    String getstudent = scanner.nextLine();
                    System.out.println(studentServiceIMPL.getStudentByFirstName(getstudent));
                    break;
                }
                case 8: {
                    System.out.print("Студенттерди табуу учун группанын атын жазыныз: ");
                    String getStudentByGroupName = scanner.nextLine();
                    System.out.println(studentServiceIMPL.getAllsudentsByGroupname(getStudentByGroupName));
                    break;
                }
                case 9: {
                    System.out.print("Студенттин почтасын жазыныз: ");
                    String email = scanner.nextLine();
                    System.out.println(lessonServiceIMPL.getAllStudentsLesson(email));
                    break;
                }
                case 10: {
                    System.out.print("Очуруло турган студенттин почтасын жазыныз: ");
                    String emailOfremovedStudent = scanner.nextLine();
                    System.out.println(studentServiceIMPL.deleteStudentByEmail(emailOfremovedStudent));
                    break;

                }
                case 11: {
                    System.out.print("Группанын атын жазыныз: ");
                    String groupname = scanner.nextLine();
                    System.out.print("Сабактын атын жазыныз: ");
                    String nameOflesson = scanner.nextLine();
                    System.out.print("Сабактын суроттомосун жазыныз: ");
                    String descOfLesson = scanner.nextLine();
                    System.out.println(groupServiceIMPL.addNewLessonToGroup(groupname, nameOflesson, null, descOfLesson));
                    break;
                }
                case 12: {
                    System.out.print("Издеп жаткан сабактын атын жазыныз: ");
                    String nameLesseon = scanner.nextLine();
                    lessonServiceIMPL.getLessonByName(nameLesseon);
                    break;
                }
                case 13: {
                    System.out.print("Сабактарды алуу учун группанын атын жазыныз: ");
                    String groupNameforAllLesson = scanner.nextLine();
                    System.out.println(lessonServiceIMPL.getAllLessonByGroupNAme(groupNameforAllLesson));
                    break;
                }
                case 14: {
                    System.out.print("Очуруло турган сабактын атын жазыныз: ");
                    String deletedLesson = scanner.nextLine();
                    System.out.println(lessonServiceIMPL.deleteLesson(deletedLesson));
                    break;
                }
                case 15: {
                    System.out.print("Очуро турган группанын атын жазыныз: ");
                    String deletedGroupname = scanner.nextLine();
                    System.out.println(groupServiceIMPL.deleteGroup(deletedGroupname));
                }
                case 16: {
                    System.exit(0);
                }
            }
        }
    }
}

