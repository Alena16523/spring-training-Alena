package com.cydeo.spring10thymeleaf1.bootstrap;

import com.cydeo.spring10thymeleaf1.model.Student;
import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    public static List<Student> createStudent(){
        List<Student> students= Arrays.asList(
                new Student(new Faker().name().firstName(), new Faker().name().lastName(), new Faker().number().numberBetween(20,50), new Faker().address().state()),
                new Student(new Faker().name().firstName(), new Faker().name().lastName(), new Faker().number().numberBetween(20,50), new Faker().address().state()),
                new Student(new Faker().name().firstName(), new Faker().name().lastName(), new Faker().number().numberBetween(20,50), new Faker().address().state()),
                new Student(new Faker().name().firstName(), new Faker().name().lastName(), new Faker().number().numberBetween(20,50), new Faker().address().state())
        );
        return students;
    }
}
