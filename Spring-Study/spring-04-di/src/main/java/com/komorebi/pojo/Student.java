package com.komorebi.pojo;

import lombok.Data;

import java.util.*;

@Data
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String, String> card;
    private Set<String> games;
    private Properties info;
    private String wife;
}
