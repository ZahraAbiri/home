package ir.maktab.model;

import ir.maktab.model.enums.OfferStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @Column(nullable = false)
    private Expert expert;
    @CreationTimestamp
    private Date registrationDate;
    private Long proposedPrice;
    private Double durationOfWork;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
    @ManyToOne
    private Order order;
    
}
