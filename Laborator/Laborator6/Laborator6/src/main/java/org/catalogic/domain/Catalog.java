package org.catalogic.domain;

import lombok.Getter;
import lombok.Setter;
import org.catalogic.exceptions.CatalogException;
import org.catalogic.exceptions.ExistingUserException;
import org.catalogic.users.Student;
import org.catalogic.users.Teacher;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class Catalog {

    private static final String NOT_FOUND_STUDENT = "STUDENT DOESN'T EXIST";
    private static final String STUDENT_ALREADY_EXISTS = "STUDENT ALREADY EXISTS";

    private Teacher teacher;

    private Set<Student> students = new TreeSet<>();

    public void addStudent(Student student) throws ExistingUserException {
        if (!students.add(student)) {
            throw new ExistingUserException(STUDENT_ALREADY_EXISTS);
        }
    }

    public Student getStudentByName(String name) throws CatalogException {
        List<Student> filteredStudents = students.stream().filter(student -> Objects.equals(student.getName(), name))
                .toList();

        if (filteredStudents.isEmpty()) {
            throw new CatalogException(NOT_FOUND_STUDENT);
        }

        return filteredStudents.get(0);
    }
}
