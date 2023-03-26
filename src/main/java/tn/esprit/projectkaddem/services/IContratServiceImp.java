package tn.esprit.projectkaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projectkaddem.entites.Contrat;
import tn.esprit.projectkaddem.entites.Etudiant;
import tn.esprit.projectkaddem.repositories.ContratRepository;
import tn.esprit.projectkaddem.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class IContratServiceImp implements IContratService{
    private  final ContratRepository contratRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouteContrat(Contrat contrat) {
      contratRepository.save(contrat);
    }

    @Override
    public void updateContrat(Contrat contrat) {
        contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Integer id) {
    contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        Assert.notNull(ce,"contrat not found");
        Assert.notNull(etudiant, "etudiant not found");
        if(etudiant.getContrats().size() <5){
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
        }
        return ce;
    }

    @Override
    public Map<String, Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        Integer nbContrat = contratRepository.findByDateDebutContratLessThanEqualAndDateFinContratGreaterThanEqualAndArchiveIsFalse(startDate,endDate).size();
        return nbContrat;
    }
}
