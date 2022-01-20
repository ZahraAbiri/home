package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expert extends Person {
    @Lob
    @Column(columnDefinition = "BLOB" ,length = 300)
    private byte[] photo;
    private Double score;
    @ManyToMany(mappedBy = "experts",fetch = FetchType.LAZY)//lazy
    private Set<SubService> services = new HashSet<>();

    @Override
    public String toString() {
        return "Expert{" +
                "photo=" + Arrays.toString(photo) +
                ", score=" + score +
                '}';
    }
}
