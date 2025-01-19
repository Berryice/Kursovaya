package com.example.demo.Tables;

import jakarta.persistence.*;

@Entity
@Table(name="cabinets")
public class Cabinets {
    public Cabinets(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
    public Cabinets() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String number;
}
