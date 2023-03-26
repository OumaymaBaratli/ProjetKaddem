package tn.esprit.projectkaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.projectkaddem.entites.Departement;
import tn.esprit.projectkaddem.entites.Universite;
import tn.esprit.projectkaddem.repositories.DepartementRepository;
import tn.esprit.projectkaddem.repositories.UniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IUniversiteServiceImp implements IUniversiteService{
    private final UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;
    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouteUniversite(Universite u) {
    universiteRepository.save(u);
    }

    @Override
    public void updateUniversite(Universite u) {
        universiteRepository.save(u);

    }

    @Override
    public void deleteUniversite(Integer id) {
    universiteRepository.deleteById(id);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        Assert.notNull(departement,"departement not found");
        Assert.notNull(universite,"universite not found");

        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.notNull(universite, "university not found");
        return universite.getDepartements();
    }
}
