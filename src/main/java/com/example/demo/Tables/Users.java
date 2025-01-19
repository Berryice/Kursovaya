package com.example.demo.Tables;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="users")
public class Users {
    public Users(Long id, String name, String phone, String blood_type, String allergy, String congenital_diseases, Date birthdate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.blood_type = blood_type;
        this.allergy = allergy;
        this.congenital_diseases = congenital_diseases;
        this.birthdate = birthdate;
    }
    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String congenital_diseases() {
        return congenital_diseases;
    }

    public void congenital_diseases(String congenital_diseases) {
        this.congenital_diseases = congenital_diseases;
    }
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String phone;
    String blood_type;
    String allergy;
    String congenital_diseases;
    Date birthdate;
}
