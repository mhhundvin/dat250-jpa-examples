package main.java;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    private Address address;

    @ManyToOne
    public Address getAddress() { return address;}

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "person")
    private final List<CreditCard> cards = new ArrayList<CreditCard>();
    public List<CreditCard> getCards() { return cards; }


}
