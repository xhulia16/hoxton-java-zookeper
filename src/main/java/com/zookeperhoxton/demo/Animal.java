package com.zookeperhoxton.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id; 
    public String name; 
    public String species; 
    public String origin;
    public boolean isHungry;

    public Animal() {

    }
}
