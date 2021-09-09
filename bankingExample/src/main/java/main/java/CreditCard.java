package main.java;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private float balance;
    private float limit;

    private Person person;
    private Bank bank;
    private Pincode pincode;

    @ManyToOne
    public Person getPerson() { return person;}

    public void setPerson(Person person) { this.person = person; }

    @ManyToOne
    public Bank getBank() { return bank;}

    public void setBank(Bank bank) { this.bank = bank; }

    @ManyToOne
    public Pincode getPincode() { return pincode;}

    public void setPincode (Pincode pincode) { this.pincode = pincode; }

}
