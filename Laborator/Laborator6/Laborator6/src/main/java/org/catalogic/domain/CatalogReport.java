package org.catalogic.domain;

import org.catalogic.exceptions.CatalogException;
import org.catalogic.users.Student;

public class CatalogReport {

    private static final int NUMBER_OF_WEEKS = 12;
    private static final String INVALID_GRADE = "INVALID_GRADE";
    private static final String WEEKS_OUT_OF_LIMIT = "THERE ARE ONLY 12 WEEKS";
    private static final String ALREADY_GRADED = "GRADE for THIS WEEK already EXISTS";

    public void addGrade(Catalog catalog, String name, Integer laboratoryNumber, Double grade) throws CatalogException {
        Student student = catalog.getStudentByName(name);

        if (student.getGrades().get(laboratoryNumber) != null) {
            throw new CatalogException(ALREADY_GRADED);
        }

        if (grade < 0.0 || grade > 10.0) {
            throw new CatalogException(INVALID_GRADE);
        }

        if (laboratoryNumber > 12) {
            throw new CatalogException(WEEKS_OUT_OF_LIMIT);
        }

        student.getGrades().put(laboratoryNumber, grade);
    }

    public Double getGradeOnASpecificWeekForStudent(Catalog catalog, String name, Integer laboratoryNumber) throws CatalogException {
        Student student = catalog.getStudentByName(name);

        if (laboratoryNumber > NUMBER_OF_WEEKS) {
            throw new IndexOutOfBoundsException(WEEKS_OUT_OF_LIMIT);
        }

        return student.getGrades().get(laboratoryNumber);
    }

    public Double getFinalGradeForStudent(Catalog catalog, String name) throws CatalogException {
        return catalog.getStudentByName(name).getGrades().values().stream().mapToDouble(grade -> grade).sum() / 12;
    }

    public boolean isStudentPassing(Catalog catalog, String name) throws CatalogException {
        return getFinalGradeForStudent(catalog, name) >= 5.0;
    }
}
