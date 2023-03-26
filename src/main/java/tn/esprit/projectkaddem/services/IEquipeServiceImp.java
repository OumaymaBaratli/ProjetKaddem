package tn.esprit.projectkaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projectkaddem.entites.Equipe;
import tn.esprit.projectkaddem.repositories.EquipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IEquipeServiceImp implements IEquipeService{
    private final EquipeRepository equipeRepository;
    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouteEquipe(Equipe e) {
    equipeRepository.save(e);
    }

    @Override
    public void updateEquipe(Equipe e) {
    equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Integer id) {
    equipeRepository.deleteById(id);
    }


}
