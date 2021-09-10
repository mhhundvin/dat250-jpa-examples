package main.java;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private int count;

}
