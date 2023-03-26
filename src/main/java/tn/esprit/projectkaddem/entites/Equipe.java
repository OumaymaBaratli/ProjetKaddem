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
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private  Integer idEquipe;
    private  String nomEquipe ;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(mappedBy = "equipes")
    private List<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailEquipe;

}
