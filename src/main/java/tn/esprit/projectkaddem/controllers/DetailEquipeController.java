package tn.esprit.projectkaddem.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectkaddem.entites.DetailEquipe;
import tn.esprit.projectkaddem.services.IDetailEquipeService;

import java.util.List;

@Tag(name = "Detail Equipe Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("detailEquipe")
public class DetailEquipeController {
    private final IDetailEquipeService iDetailEquipeService;

    @GetMapping
    public List<DetailEquipe> getAll(){
        return iDetailEquipeService.getAllDetailEquipe();
    }
    @GetMapping("/{id}")
    public DetailEquipe get(@PathVariable Integer id){
        return iDetailEquipeService.getDetailEquipeById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        iDetailEquipeService.deleteDetailEquipe(id);
    }
    @PutMapping
    public void update(@RequestBody DetailEquipe d){
        iDetailEquipeService.updateDetailEquipe(d);
    }
    @PostMapping
    public void add(@RequestBody DetailEquipe d){
        iDetailEquipeService.ajouteDetailEquipe(d);
    }
}
