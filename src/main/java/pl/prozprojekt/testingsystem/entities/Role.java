package pl.prozprojekt.testingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    Role(String name){
        this.name = name;
    }

    Role(){

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
