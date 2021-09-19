package no.hvl.dat250.jpa.basicexample.part2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue
    private Long id;

    private Integer number;
    private Integer limit;
    private Integer balance;
    private Pincode pin;
    @ManyToOne
    private Bank bank;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Pincode getPin() {
        return pin;
    }

    public void setPin(Pincode pin) {
        this.pin = pin;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }




}
