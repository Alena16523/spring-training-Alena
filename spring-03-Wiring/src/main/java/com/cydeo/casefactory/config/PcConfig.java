package com.cydeo.casefactory.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimentions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    @Bean
    public Dimentions dimentions(){
        return new Dimentions(50, 10, 10);
    }

    @Bean
    public Case caseDell(Dimentions dimentions){
        return new DellCase("220B", "Dell", "240",dimentions );
    }

}
