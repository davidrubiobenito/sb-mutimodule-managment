package com.drbotro.coreserviceapi.doctor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor{

    @Id
    private int id;
    private String name;
    private String email;

    public Doctor(){
        super();
    }

    public Doctor(int id, String name, String email){
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Doctor [");
        strBuilder.append("id=");
        strBuilder.append(id);
        strBuilder.append(", name=");
        strBuilder.append(name);
        strBuilder.append(", email=");
        strBuilder.append(email);
        strBuilder.append("]");
        return strBuilder.toString();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
