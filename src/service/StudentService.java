package service;

import models.Group;
import models.Student;

import java.util.List;

public interface StudentService {

    void addStudent (String groupName, Student student);

    void updateStudent(String groupName, String studentFirstName, String newFirstName, String newLastName, String newEmail) throws Exception;

    Student findStudentByFirstName (String firstName);

    List<Student> getAllStudentsByGroupName (String groupName);

    void deleteStudent (String groupName, String studentFirstName);


}

