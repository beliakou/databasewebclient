package core.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "disorders")
public class Disorder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    @Size(max = 200)
    String disorder;

    @ManyToMany(mappedBy = "disorders")
    @JsonFilter("OnlyIdFilter")
    Set<Survey> surveys = new HashSet<>();
}
