package no.hvl.dat250.jpa.basicexample.part2;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private Integer number;
    @ManyToMany
    private ArrayList<Person> residents;

    public ArrayList<Person> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<Person> residents) {
        this.residents = residents;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }



}
