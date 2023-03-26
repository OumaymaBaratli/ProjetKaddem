package tn.esprit.projectkaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projectkaddem.entites.Contrat;
import tn.esprit.projectkaddem.entites.Departement;
import tn.esprit.projectkaddem.entites.Equipe;
import tn.esprit.projectkaddem.entites.Etudiant;
import tn.esprit.projectkaddem.repositories.ContratRepository;
import tn.esprit.projectkaddem.repositories.DepartementRepository;
import tn.esprit.projectkaddem.repositories.EquipeRepository;
import tn.esprit.projectkaddem.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IEtudiantServiceImp implements  IEtudiantService{
    private final EtudiantRepository etudiantRepository;
    private final DepartementRepository departementRepository;
    private final ContratRepository contratRepository;
    private final EquipeRepository equipeRepository;
    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouteEtudiant(Etudiant e) {
    etudiantRepository.save(e);
    }

    @Override
    public void updateEtudiant(Etudiant e) {
    etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Integer id) {
    etudiantRepository.deleteById(id);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        // recuperation des objets
        Departement departement = departementRepository.findById(departementId).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);  // ou = this.getByIdEtudiant(etudiantId);
        // verification des objets
        Assert.notNull(departement,"departement not found");
        Assert.notNull(etudiant,"etudiant not found");
        // traitement
            etudiant.setDepartement(departement);
            etudiantRepository.save(etudiant);

    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Assert.notNull(contrat,"contrat not found");
        Assert.notNull(equipe,"equipe not found");
        Assert.notNull(e,"null etudiant object");
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        e.setEquipes(equipes);
        etudiantRepository.saveAndFlush(e);

        contrat.setEtudiant(e);

        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.findByDepartementIdDepart(idDepartement);
    }
}
