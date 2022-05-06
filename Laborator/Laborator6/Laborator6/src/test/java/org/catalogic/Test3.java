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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Test3 {

    /*
     * For the third test, lets make sure that we can add a grade for a student.
     *
     * == TASK_4 == : Write the test for adding a VALID grade for an EXISTING student for Laboratory no. 6.
     *
     * == TASK_5 == : Write the test for adding an INVALID grade (<0 or >10) for an EXISTING student for Laboratory no. 6.
     *
     * == TASK_6 == : Write the test for adding a VALID grade for an NON-EXISTING student for Laboratory no. 6.
     *
     * == TASK_7 == : Write the test for adding a VALID grade for an EXISTING student for a Laboratory out of bounds (>12).
     *
     * == TASK_8 == : Write the test for adding a VALID grade for an EXISTING student for Laboratory no. 6 when it was
     * already graded.
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
    void addGrade_ValidInput_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        report.addGrade(catalog, "Pedri Gonzalez", 6, 9.00);

        assertEquals(report.getGradeOnASpecificWeekForStudent(catalog, "Pedri Gonzalez", 6), 9.00);
    }

    /* TASk_5 */
    @Test
    void addGrade_InvalidGrade_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */

        CatalogException exception = assertThrows(CatalogException.class, () -> {
            report.addGrade(catalog, "Ronald Araujo", 6, 11.00);
        });

        assertEquals("INVALID_GRADE", exception.getMessage());
    }

    /* TASk_6 */
    @Test
    void addGrade_InvalidStudent_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */
        CatalogException exception = assertThrows(CatalogException.class, () -> {
            report.addGrade(catalog, "Martin Braithwaite", 6, 8.50);
        });

        assertEquals("STUDENT DOESN'T EXIST", exception.getMessage());
    }

    /* TASk_7 */
    @Test
    void addGrade_InvalidLaboratory_ThrowsCatalogException() {
        /* IF I PASS, YOU PASS */
        CatalogException exception = assertThrows(CatalogException.class, () -> {
            report.addGrade(catalog, "Ferran Torres", 13, 5.50);
        });

        assertEquals("THERE ARE ONLY 12 WEEKS", exception.getMessage());
    }

    /* TASk_8 */
    @Test
    void addGrade_AlreadyGraded_ThrowsCatalogException() throws CatalogException {
        /* IF I PASS, YOU PASS */
        report.addGrade(catalog, "Gerard Pique", 9, 7.50);

        CatalogException exception = assertThrows(CatalogException.class, () -> {
            report.addGrade(catalog, "Gerard Pique", 9, 7.50);
        });

        assertEquals("GRADE for THIS WEEK already EXISTS", exception.getMessage());
    }

}
