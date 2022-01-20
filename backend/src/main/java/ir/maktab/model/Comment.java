package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double score;
    String desciption;
    @ManyToOne
    private Customer customer;
    @ManyToOne
//    (nullabale=flase)
    private Expert expert;
    @OneToOne
    private Order order;
}
