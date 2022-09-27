package com.cydeo.casefactory;

public class DellCase extends Case {

    public DellCase(String model, String manufacturer, String powerSupply, Dimentions dimentions) {
        super(model, manufacturer, powerSupply, dimentions);
    }

    public void pressPowerButton() {

        System.out.println("Power button pressed");
    }

}
