package tn.esprit.projectkaddem.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectkaddem.entites.Equipe;
import tn.esprit.projectkaddem.services.IEquipeService;

import java.util.List;

@Tag(name = "Equipe Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("equipe")
public class EquipeController {
    private final IEquipeService iEquipeService;

    @GetMapping
    public List<Equipe> getAll(){
        return iEquipeService.getAllEquipe();
    }
    @GetMapping("/{id}")
    public Equipe get(@PathVariable Integer id){
        return iEquipeService.getEquipeById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        iEquipeService.deleteEquipe(id);
    }
    @PutMapping
    public void update(@RequestBody Equipe d){
        iEquipeService.updateEquipe(d);
    }
    @PostMapping
    public void add(@RequestBody Equipe d){
        iEquipeService.ajouteEquipe(d);
    }
}
