package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private Long basePrice;
    private String description;
    @ManyToOne
    private MainService mainService;
    @ManyToMany
    private Set<Expert> experts = new HashSet<Expert>();

    @Override
    public String toString() {
        return "SubService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                ", mainService=" + mainService +
                '}';
    }
}
