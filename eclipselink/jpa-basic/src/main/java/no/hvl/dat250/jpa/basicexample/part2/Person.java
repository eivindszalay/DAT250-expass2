package no.hvl.dat250.jpa.basicexample.part2;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "residents")
    private ArrayList<Address> addresses;
    private ArrayList<CreditCard> creditCards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
