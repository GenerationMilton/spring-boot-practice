package net.javaguideslivemilton.springboot_rest_api.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {

    private int id;
    private String firstName;
    private String lastName;
}
