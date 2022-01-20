package ir.maktab.model;

import ir.maktab.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SubService subService;
    private Long proposedPrice;
    @Column(length = 300)
    private String jobDescription;
    @CreationTimestamp
    private Date orderRegistrationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfWorkPerformed;
    @OneToOne
    private Address address;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<Offer> offers = new HashSet<>();
    @ManyToOne
    private Expert expert;

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", proposedPrice=" + proposedPrice +
                ", jobDescription='" + jobDescription + '\'' +
                ", orderRegistrationDate=" + orderRegistrationDate +
                ", dateOfWorkPerformed=" + dateOfWorkPerformed +
                ", address='" + address + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return Objects.equals(id, that.id) && Objects.equals(proposedPrice, that.proposedPrice) && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(orderRegistrationDate, that.orderRegistrationDate) && Objects.equals(dateOfWorkPerformed, that.dateOfWorkPerformed) && Objects.equals(address, that.address) && orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proposedPrice, jobDescription, orderRegistrationDate, dateOfWorkPerformed, address, orderStatus);
    }
}
