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

    public Role(String name){
        this.name = name;
    }

    public Role(){

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
