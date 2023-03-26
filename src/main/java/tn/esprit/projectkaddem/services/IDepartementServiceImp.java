package tn.esprit.projectkaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projectkaddem.entites.Departement;
import tn.esprit.projectkaddem.repositories.DepartementRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IDepartementServiceImp implements IDepartementService{
    private final DepartementRepository departementRepository;
    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement GetDepartementById(Integer id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouteDepartement(Departement d) {
        departementRepository.save(d);
    }

    @Override
    public void updateDepartement(Departement d) {
    departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(Integer id) {
        departementRepository.deleteById(id);
    }
}
