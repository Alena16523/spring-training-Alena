package com.cydeo.entity;

import javax.persistence.*;

@MappedSuperclass //no table creation from this class instead of @Entity
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
