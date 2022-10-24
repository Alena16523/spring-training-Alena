package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Department {

    private String department;
    private String division;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
