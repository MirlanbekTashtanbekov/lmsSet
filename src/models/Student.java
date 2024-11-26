package models;

import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;

    //private List<Lesson> lessons = new ArrayList<>();

    public Student() {
    }

    public Student(Long studentId, String firstName, String lastName, String email, String password, Gender gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;

    }


//    public Student(Long studentId, String firstName, String lastName, String email, String password, Gender gender, List<Lesson> lessons) {
//        this.studentId = studentId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.gender = gender;
//
//        //this.lessons = lessons;
//    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    //
//    @Override
//    public List<Lesson> getLessons() {
//        return lessons;
//    }
//
//    @Override
//    public void setLessons(List<Lesson> lessons) {
//        this.lessons = lessons;
//    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender;
    }
}
