package org.catalogic.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher implements User{
    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
