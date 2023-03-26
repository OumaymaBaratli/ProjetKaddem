package tn.esprit.projectkaddem.entites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idDepart;
    private String nomDepart;
    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiants;
}
