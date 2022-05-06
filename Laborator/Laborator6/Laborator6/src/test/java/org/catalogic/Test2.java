package org.catalogic;

import org.catalogic.exceptions.CatalogException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.catalogic.users.Student;
import org.catalogic.domain.Catalog;
import org.catalogic.constants.UserType;
import org.catalogic.factory.UsersFactory;
import org.catalogic.exceptions.ExistingUserException;

import static org.junit.jupiter.api.Assertions.*;

class Test2 {

    /*
     * For the second test, lets make sure that our catalog is throwing the right exception WHEN needed.
     *
     * == TASK_2 == : Write the test for the positive scenario for getStudentByName.
     *
     * Use the 'addStudent_ValidStudent_PositiveScenario' as a guide.
     *
     * == TASK_3 == : Complete the 'getStudentByName_InsertInvalidName_ThrowsNotFoundException' test to verify
     *  that our method throws the proper exception when an invalid name of student is given.
     *
     * Use the 'addStudent_InsertAlreadyExistingStudent_ThrowsDuplicateException' as a guide.
     * */

    Catalog defenseAgainstDarkArts;

    @BeforeEach
    void setUp() {
        defenseAgainstDarkArts = new Catalog();
    }

    @Test
    void addStudent_ValidStudent_PositiveScenario() throws ExistingUserException {
        defenseAgainstDarkArts.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Hermione Granger"));

        assertFalse(defenseAgainstDarkArts.getStudents().isEmpty());
    }

    @Test
    void addStudent_InsertAlreadyExistingStudent_ThrowsDuplicateException() throws ExistingUserException {
        defenseAgainstDarkArts.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Hermione Granger"));

        ExistingUserException exception = assertThrows(ExistingUserException.class, () -> {

            defenseAgainstDarkArts.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Hermione Granger"));

        });

        assertEquals("STUDENT ALREADY EXISTS", exception.getMessage());

        assertEquals(1, defenseAgainstDarkArts.getStudents().size());
    }

    /* TASk_2 */
    @Test
    void getStudentByName_InsertInvalidName_ThrowsNotFoundException() throws CatalogException {
        /* IF I PASS, YOU PASS */

        defenseAgainstDarkArts.addStudent((Student) UsersFactory.create(UserType.STUDENT, "Marcus Rashford"));

        assertFalse(defenseAgainstDarkArts.getStudents().isEmpty());

        CatalogException exception = assertThrows(CatalogException.class, () -> {

            Student stud = defenseAgainstDarkArts.getStudentByName("Adebayo Akinfenwa");

        });

        assertEquals("STUDENT DOESN'T EXIST", exception.getMessage());
    }

    /* TASk_3 */
    @Test
    void getStudentByName_ValidStudent_PositiveScenario() throws CatalogException {
        /* IF I PASS, YOU PASS */
        Student casillas = (Student) UsersFactory.create(UserType.STUDENT, "Iker Casillas");
        defenseAgainstDarkArts.addStudent(casillas);

        assertFalse(defenseAgainstDarkArts.getStudents().isEmpty());

        Student stud = defenseAgainstDarkArts.getStudentByName("Iker Casillas");

        assertEquals(stud, casillas);
    }
}
