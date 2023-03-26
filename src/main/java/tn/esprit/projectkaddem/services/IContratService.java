package tn.esprit.projectkaddem.services;

import tn.esprit.projectkaddem.entites.Contrat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IContratService {

    List<Contrat> getAllContrats();

    Contrat getContratById(Integer id);

    void ajouteContrat( Contrat contrat);
    void updateContrat(Contrat contrat);
    void deleteContrat(Integer id);
    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
    public Map<String,Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate,
                                                            Date endDate);
    Integer nbContratsValides(Date startDate, Date endDate);

}
