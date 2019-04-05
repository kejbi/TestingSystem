package pl.prozprojekt.testingsystem.entities;

import javax.persistence.Entity;

@Entity
public class Student extends User {
    //na razie do testow proste inty, potem będa to listy lub inne kolekcje
    int tests;
    int rozwiazane;

}
