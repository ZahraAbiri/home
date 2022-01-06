package ir.maktab.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Commit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double score;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @OneToOne
    private Order order;
}
