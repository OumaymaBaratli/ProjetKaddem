package tn.esprit.projectkaddem.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    @JsonIgnore
    private  Departement departement;
    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;
    @JsonIgnore
    @ManyToMany
    private List<Equipe> equipes;
}
