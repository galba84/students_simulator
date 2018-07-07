package model;

import model.enumerations.GroupNames;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<Student> students = new ArrayList<Student>();

    public Group(int id) {
        this.id = id;
        this.name = GroupNames.values()[id].name();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
