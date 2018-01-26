package com.javarush.task.task29.task2909.human;

import java.util.LinkedList;
import java.util.List;

public class University {
    private List<Student> students = new LinkedList<Student>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double rating) {
        return students.stream().filter(x -> rating == x.getAverageGrade()).findFirst().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        return students.stream().max((x, y) -> Double.compare(x.getAverageGrade(), y.getAverageGrade())).get();
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream().min((x, y) -> Double.compare(x.getAverageGrade(),y.getAverageGrade())).get();
    }

    public void expel(Student student) {
        students.remove(student);
    }
}