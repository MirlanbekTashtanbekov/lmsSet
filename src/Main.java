import com.sun.source.tree.WhileLoopTree;
import database.GenerateId;
import enums.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import org.w3c.dom.ls.LSOutput;
import service.GroupService;
import service.LessonService;
import service.StudentService;
import service.serviceImpl.GroupServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import database.Database;
import service.serviceImpl.LessonServiceImpl;
import service.serviceImpl.StudentServiceImpl;

import static database.GenerateId.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        int localTimeHour = localTime.getHour();
        int localTimeMinute = localTime.getMinute();
        if (localTimeHour>18){
            System.out.println("Good evening: "+ localTimeHour+":"+localTimeMinute);
        } if (localTimeHour>0 && localTimeHour<6){
            System.out.println("Good night : "+ localTimeHour+":"+localTimeMinute);
        } if (localTimeHour>6 && localTimeHour<12){
            System.out.println("Good morning: "+ localTimeHour+":"+localTimeMinute);
        } if (localTimeHour>12 && localTimeHour<18){
            System.out.println("Good afternoon: "+ localTimeHour+":"+localTimeMinute);
        }

        GroupService groupService = new GroupServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        LessonService lessonService = new LessonServiceImpl();

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

            System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калсаныз озгортуу учун 2 басыныз: ");
            int choiseAdmin = scanner1.nextInt();
            switch (choiseAdmin) {
                case 1 -> {
                    String adminName = "Admin";
                    String adminEmail = "admin@gmail.com";
                    String adminParol = "admin123";
                    System.out.println("Кируу учун почтанызды жана паролунузду жазыныз: ");
                    System.out.print("Почтанызды жазыныз: ");
                    String scanGmail = new Scanner(System.in).nextLine();
                    System.out.print("Пароль жазыныз: ");
                    String scanPassword = new Scanner(System.in).nextLine();
                    if (scanGmail.equals(adminEmail) && scanPassword.equals(adminParol)) {
                        System.out.println("Кош келиниз!");
                        while (true) {
                            System.out.println("*** Бир команда танданыз*** ");
                            System.out.println("""
                                    1-> Save group;
                                    2-> Get group by name;
                                    3-> Update group;
                                    4-> Get all groups;
                                    5-> Add new student;
                                    6-> Update student;
                                    7-> Find student by first name;
                                    8-> Get all students by group name;
                                    9-> Delete student;
                                    10-> Add new lesson;
                                    11-> Get lesson by name;
                                    12-> Delete lesson;
                                    13-> Delete group;
                                    """);
                            int choisNumber = scanner2.nextInt();
                            try {
                                switch (choisNumber) {
                                    case 1 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        System.out.print("Группанын суроттомосун жазыныз: ");
                                        String groupDescription = scanner3.nextLine();
                                        Group newGroup = new Group(GenerateId.groupId(), groupName, groupDescription);
                                        groupService.saveGroup(groupName, groupDescription);
                                        System.out.println(newGroup);
                                        System.out.println(groupName + " атуу группа ийгиликтуу сакталды!");
                                    }
                                    case 2 -> {
                                        System.out.println("Группаны табуу учун атын жазыныз: ");
                                        String getGroupName = scanner3.nextLine();
                                        System.out.println(groupService.getGroupByName(getGroupName));
                                    }
                                    case 3 -> {
                                        GenerateId.groupId();
                                        System.out.println("Группанын эски атын жазыныз:");
                                        String groupOldName = scanner3.nextLine();
                                        System.out.println("Группанын жаны атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        System.out.println(groupService.updateGroupName(groupOldName, groupName));

                                    }
                                    case 4 -> System.out.println(groupService.getAllGroups());
                                    case 5 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        System.out.print("Студенттин атын жазыныз: ");
                                        String firstName = scanner3.nextLine();
                                        System.out.print("Студенттин фамилиясын жазыныз: ");
                                        String lastName = scanner3.nextLine();
                                        System.out.print("Студенттин email почтасын жазыныз: ");
                                        String email = scanner3.nextLine();
                                        System.out.print("Студенттин паролун жазыныз: ");
                                        String password = scanner3.nextLine();
                                        System.out.print("Студенттин жынысын танданыз: (MALE/FEMALE): ");
                                        Gender gender = Gender.valueOf(scanner3.nextLine().toUpperCase());
                                        Student student = new Student(GenerateId.studentId(), firstName, lastName, email, password, gender);
                                        studentService.addStudent(groupName, student);

                                    }
                                    case 6 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        System.out.print("Студенттин эски атын жазыныз: ");
                                        String studentName = scanner3.nextLine();
                                        System.out.print("Студенттин жаны атын жазыныз: ");
                                        String newFirstName = scanner3.nextLine();
                                        System.out.print("Студенттин жаны фамилиясын жазыныз: ");
                                        String newLastName = scanner3.nextLine();
                                        System.out.print("Студенттин жаны email почтасын жазыныз: ");
                                        String newEmail = scanner3.nextLine();
                                        studentService.updateStudent(groupName, studentName, newFirstName, newLastName, newEmail);
                                    }
                                    case 7 -> {
                                        System.out.print("Студенттин атын жазыныз: ");
                                        String studentName = scanner3.nextLine();
                                        Student student = studentService.findStudentByFirstName(studentName);
                                        System.out.println("Студент табылды: " + student);
                                    }
                                    case 8 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        studentService.getAllStudentsByGroupName(groupName).forEach(System.out::println);
                                    }
                                    case 9 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        System.out.print("Студенттин атын жазыныз: ");
                                        String studentName = scanner3.nextLine();
                                        studentService.deleteStudent(groupName, studentName);

                                    }
                                    case 10 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanner3.nextLine();
                                        System.out.print("Сабактын атын жазыныз: ");
                                        String lessonName = scanner3.nextLine();
                                        System.out.print("Сабактын озгочолугу: ");
                                        String description = scanner3.nextLine();
                                        lessonService.addLessonToGroup(groupName, lessonName, description);
                                    }
                                    case 11 -> {
                                        System.out.println("Сабактын атын жазыныз: ");
                                        String lessonName = scanner3.nextLine();
                                        System.out.println(lessonService.getLessonByName(lessonName));
                                    }
                                    case 12 -> {
                                        System.out.println("Сабакты очуруу учун атын жазыныз: ");
                                        String lessonNameDelete = scanner3.nextLine();
                                        System.out.println(lessonService.deleteLesson(lessonNameDelete));
                                    }
                                    case 13 -> {
                                        System.out.println("Группаны очуруу учун атын жазыныз: ");
                                        String groupNameDelet = scanner3.nextLine();
                                        System.out.println(groupService.deleteGroup(groupNameDelet));
                                    }
                                    default -> System.out.println("Неверная команда. Попробуйте снова.");
                                }
                            } catch (Exception e) {
                                System.out.println("Ката: " + e.getMessage());
                            }
                        }
                    }
                }
                case 2 -> System.out.println("Озгортуу киргизиш керек");
            }

        // TODO проверка методов для Группы
//        Group group1 = new Group(GenerateId.groupId(),"Java","Java Offline Day"); // проверил на создание новых групп
//        Group group2 = new Group(GenerateId.groupId(),"Js","Js Online evening");
//        groupService.saveGroup(group1);
//        groupService.saveGroup(group2);
//
//        System.out.println(groupService.getAllGroups()); // проверка вызова всех групп
//        System.out.println(groupService.getGroupByName("Java"));  // проверка вызова группу по имени
//        groupService.updateGroup(2L,new Group(GenerateId.groupId(),"C++","Online"));  // проверка на обновление изменение данных в группе
//        System.out.println(groupService.getAllGroups());
//        System.out.println(groupService.deleteGroup(2L));   // удаление группы
//        System.out.println(groupService.getAllGroups());
        // TODO проверка на автономерацию для Id
        /*Group group = new Group(GenerateId.groupId(),"Java");    // проверка на автогенерацию Id
        System.out.println(group);
        Student student = new Student(GenerateId.studentId(),"Dan"); // проверка на автогенерацию id Student
        System.out.println(student); */

        // TODO проверка метода студент
        /*System.out.println("~~~~~~~~~~~STUDENTS METHODS~~~~~~~~~~~~");
        Student student1 = new Student(GenerateId.studentId(),"Mark","Denvud","mark@gmail.com","12345", Gender.MALE,group1);
        Student student2 = new Student(GenerateId.studentId(),"Arian","Ferrius","arian@gmail.com","123456",Gender.FEMALE,group2);
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        System.out.println("By group name");
        System.out.println(studentService.getAllStudentsByGroupName("Java"));
        System.out.println("By firstName");
        System.out.println(studentService.findStudentByFirstName("Mark"));
        System.out.println("Update");
        studentService.update(2L, new Student(GenerateId.studentId(),"Tommy","Anderson","tommy@gmail.com","1234567",Gender.MALE,group2));
        System.out.println(studentService.getAllStudentsByGroupName("Java"));
        System.out.println("Delete");
        System.out.println(studentService.deleteStudent(1L));
        System.out.println(studentService.getAllStudentsByGroupName("Java"));

        //TODO проверка method lesson
        System.out.println("~~~~~~LESSON METHODS~~~~~~~~~~~");
        Lesson lesson1 = new Lesson("ArrayList","Collection");
        Lesson lesson2 = new Lesson("Set", "Method");
        lessonService.addLesson(lesson1);
        lessonService.addLesson(lesson2);
        System.out.println(lessonService.getLessonByName("Set"));
        System.out.println(lessonService.getLessonByName("ArrayList"));
        System.out.println(lessonService.deleteLesson("Set"));*/

    }
}