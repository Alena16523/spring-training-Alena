package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToMany
    @JoinTable(name="cart_item_rel",
    joinColumns = @JoinColumn(name="c_id"),
    inverseJoinColumns = @JoinColumn(name="i_id"))
    private List<Item> itemList;


}