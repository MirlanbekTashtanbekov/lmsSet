package service.serviceImpl;

import database.Database;
import database.GenerateId;
import models.Group;
import models.Student;
import service.StudentService;

import java.util.List;

import static database.Database.groups;
import static database.Database.students;

public class StudentServiceImpl implements StudentService {

    @Override
    public void addStudent(String groupName, Student student) {
        Group group = new GroupServiceImpl().getGroupByName(groupName);
        Long studentId = GenerateId.studentId();
        group.getStudents().add(student);
        Database.students.add(student);
        System.out.println(student);

    }

    @Override
    public void updateStudent(String groupName, String studentFirstName, String newFirstName, String newLastName, String newEmail) throws Exception {
        Group group = new GroupServiceImpl().getGroupByName(groupName);
        Student student = group.getStudents().stream()
                .filter(s -> s.getFirstName().equalsIgnoreCase(studentFirstName))
                .findFirst()
                .orElseThrow(() -> new Exception("Ката атында " + studentFirstName + " бул группада жок " + groupName));

        student.setFirstName(newFirstName);
        student.setLastName(newLastName);
        student.setEmail(newEmail);

        System.out.println("Студенттин маалыматы озгортулду: " + studentFirstName + " -> " + newFirstName + " " + newLastName);
    }


    @Override
    public Student findStudentByFirstName(String firstName) { //men
        for (Student student:Database.students){
            if (student.getFirstName().contains(firstName)){
                return student;
            }
        }
        return null;
    }


    @Override
    public List<Student> getAllStudentsByGroupName(String groupName) {
        for (Group group : groups){
            if (group.getName().equalsIgnoreCase(groupName)){
                return students;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(String groupName, String studentFirstName) {
        for (Group group : groups){
            for (Student student : students)
            if (student.getFirstName().equalsIgnoreCase(studentFirstName)){
                Database.students.remove(student);
                System.out.println(student+ "ийгиликтуу очурулду!");
            }
        }
    }
}
