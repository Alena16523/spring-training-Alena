package com.cydeo.casefactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Case {

    private String model;
    private String manufacturer;
    private String powerSupply;
    private Dimentions dimentions;

    public Case(String model, String manufacturer, String powerSupply, Dimentions dimentions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimentions=dimentions;
    }

    public abstract void pressPowerButton();
}
