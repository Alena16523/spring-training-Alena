package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"address", "country", "state"}, ignoreUnknown = true) //to ignore multiple fields
@JsonIgnoreProperties(ignoreUnknown = true) //if anything typed not related to fields will be ignored
public class AccountDTO {

    @JsonIgnore
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @JsonBackReference //this field is not going to be serialized (not gonna be converted at Json)
    private UserDTO user;

}
