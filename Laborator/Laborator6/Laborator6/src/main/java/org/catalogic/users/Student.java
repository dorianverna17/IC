package org.catalogic.users;

import lombok.Setter;
import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class Student implements User, Comparable<Student> {

    private String name;

    private Map<Integer, Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new TreeMap<>();
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
}
