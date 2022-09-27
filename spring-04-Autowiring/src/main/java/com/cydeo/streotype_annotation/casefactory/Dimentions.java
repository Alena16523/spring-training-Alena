package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Dimentions {
    private int width;
    private int height;
    private int depth;

    public Dimentions() {
        this.width =10;
        this.height = 10;
        this.depth = 10;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }

}
