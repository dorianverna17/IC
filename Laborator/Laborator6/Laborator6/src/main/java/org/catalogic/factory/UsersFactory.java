package org.catalogic.factory;

import org.catalogic.users.User;
import org.catalogic.users.Student;
import org.catalogic.users.Teacher;
import org.catalogic.constants.UserType;

public class UsersFactory {

    private UsersFactory() {}

    public static User create(UserType userType, String name) {
        return userType == null ? null : switch (userType) {
            case STUDENT -> new Student(name);
            case TEACHER -> new Teacher(name);
        };
    }
}
