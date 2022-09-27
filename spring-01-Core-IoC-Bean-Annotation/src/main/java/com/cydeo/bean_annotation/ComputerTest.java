package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        //creating container
        ApplicationContext container=new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        //retrieving the beans
        //Monitor theMonitor=container.getBean(Monitor.class);
        //SonyMonitor sony=container.getBean(SonyMonitor.class);
//        AsusMotherboard asus=container.getBean(AsusMotherboard.class);
//        DellCase dell=container.getBean(DellCase.class);

        //PC myPc=new PC(dell, sony, asus);

        //myPc.powerUp();

        //dell.pressPowerButton();

        //retrieving the beans

//        Monitor theMonitor=container.getBean(SonyMonitor.class);
//        Case theCase=container.getBean(Case.class);
//        Motherboard theMotherboard=container.getBean(Motherboard.class);
//
//        PC myPC2= new PC(theCase, theMonitor, theMotherboard);

        System.out.println("Multiple objects:");

//        Monitor theMonitor2=container.getBean("monitorSony", Monitor.class); //default bean name(method name)
//        Monitor theMonitor3=container.getBean("sony", Monitor.class); //custom bean name
        Monitor theMonitor4=container.getBean( Monitor.class); //will give @primary "Acer"

    }
}
