package org.catalogic;

import org.catalogic.constants.UserType;
import org.catalogic.domain.Catalog;
import org.catalogic.domain.CatalogReport;
import org.catalogic.exceptions.CatalogException;
import org.catalogic.exceptions.ExistingUserException;
import org.catalogic.factory.UsersFactory;
import org.catalogic.users.Student;
import org.catalogic.users.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Test4 {

    /*
     * For the final test, lets make sure that we can add a grade for a student.
     *
     * == TASK_9 == : run tests with coverage. Make coverage 100% by adding in this class all the tests needed.
     *
     * */
    Catalog catalog;
    CatalogReport report;
    Teacher teacher;

    @BeforeEach
    void setUp() throws ExistingUserException {
        /* I might be useful. */
        catalog = new Catalog();
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Marc-Andre Ter Stegen"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Dani Alves"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Gerard Pique"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Ronald Araujo"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Jordi Alba"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Sergio Busquets"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Frenkie De Jong"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Pedri Gonzalez"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Ousmane Dembele"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Pierre-Emerick Aubameyang"));
        catalog.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Ferran Torres"));

        teacher = (Teacher) UsersFactory.create(UserType.TEACHER, "Xavi Hernandez");

        report = new CatalogReport();
    }

    /* TASk_4 */
    @Test
    void getFinalGradeForStudent_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        report.addGrade(catalog, "Pedri Gonzalez", 6, 9.00);
        report.addGrade(catalog, "Pedri Gonzalez", 7, 3.00);

        assertEquals(report.getFinalGradeForStudent(catalog, "Pedri Gonzalez"), 1.00);
    }

    @Test
    void isStudentPassing_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        report.addGrade(catalog, "Pedri Gonzalez", 6, 9.00);
        report.addGrade(catalog, "Pedri Gonzalez", 7, 3.00);

        assertEquals(report.isStudentPassing(catalog, "Pedri Gonzalez"), false);
    }

    @Test
    void catalog_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        Catalog cat = new Catalog();

        assertNotNull(cat);
    }

    @Test
    void setterGetterCatalog_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        catalog.setTeacher(teacher);

        Teacher t = catalog.getTeacher();
        assertNotNull(t);
    }

    @Test
    void setterGetterStudent_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        Student stud = catalog.getStudentByName("Pedri Gonzalez");

        stud.setName("Pedro Rodriguez");

        assertEquals("Pedro Rodriguez", stud.getName());
    }

    @Test
    void setterGetterTeacher_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        catalog.setTeacher(teacher);
        Teacher stud = catalog.getTeacher();

        stud.setName("Pep Guardiola");

        assertEquals("Pep Guardiola", stud.getName());
    }

    @Test
    void getGradeOnASpecificWeekForStudent_InsertInvalidLaboratory_ThrowsIndexOutOfBoundsException() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            report.getGradeOnASpecificWeekForStudent(catalog, "Pedri Gonzalez", 13);
        });

        assertEquals("THERE ARE ONLY 12 WEEKS", exception.getMessage());
    }
}
