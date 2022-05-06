package org.catalogic;

import org.catalogic.users.Student;
import org.catalogic.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.catalogic.users.Teacher;
import org.catalogic.constants.UserType;
import org.catalogic.factory.UsersFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class Test1 {

    /*
    * For the first test, lets make sure that our users are created correspondingly.
    *
    * == TASK_1 == : Complete the 'create_ValidStudent_InstanceOfStudent' test to verify that the factory
    * creates the right instances.
    *
    * Use the 'create_ValidTeacher_InstanceOfTeacher' test as a guide.
    * */

    @Test
    void create_ValidTeacher_InstanceOfTeacher() {
        User teacher = UsersFactory.create(UserType.TEACHER, "Severus Snape");
        /* Make sure the object is not null */
        assertNotNull(teacher);
        /* Make sure the object has the right type */
        assertThat(teacher, instanceOf(Teacher.class));
    }

    @Test
    void create_ValidStudent_InstanceOfStudent() {
        /* IF I PASS, YOU PASS */
        User student = UsersFactory.create(UserType.STUDENT, "Edinson Cavani");
        assertNotNull(student);
        assertThat(student, instanceOf(Student.class));
    }
}
