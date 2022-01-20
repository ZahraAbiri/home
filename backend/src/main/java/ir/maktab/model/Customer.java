package ir.maktab.model;

import ir.maktab.model.enums.PersonStatuse;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@Builder
@Getter
@Service
public class Customer extends Person{

//    public Customer() {
//        super();
//    }
}
