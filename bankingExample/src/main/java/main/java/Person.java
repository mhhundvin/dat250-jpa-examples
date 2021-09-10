package main.java;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;



    @ManyToMany
    @JoinTable(
            name = "addresses",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    Set<Address> addresses;


    @OneToMany(mappedBy = "person")
    private final List<CreditCard> cards = new ArrayList<CreditCard>();
    public List<CreditCard> getCards() { return cards; }


}
