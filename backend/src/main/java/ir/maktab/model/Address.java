package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String city;
    private String streetAddress;
    private String houseNumber;
    @Column(unique = true)
    private Long zipCode;
}
