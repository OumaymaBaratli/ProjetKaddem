package tn.esprit.projectkaddem.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectkaddem.entites.Contrat;
import tn.esprit.projectkaddem.services.IContratService;

import java.util.Date;
import java.util.List;

@Tag(name = "Contrat Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("contrat")
public class ContratController {
    private final IContratService iContratService;

    @GetMapping
    public List<Contrat> getAll(){
        return iContratService.getAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat get(@PathVariable Integer id){
        return iContratService.getContratById(id);
    }

    @PostMapping()
    public void add(@RequestBody Contrat c){
        iContratService.ajouteContrat(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        iContratService.deleteContrat(id);
    }

    @PutMapping()
    public void update(@RequestBody Contrat c){
        iContratService.updateContrat(c);
    }
    @PostMapping("/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable String nomE,@PathVariable String prenomE) {
        return iContratService.affectContratToEtudiant(ce, nomE, prenomE);
    }

    @GetMapping("/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable Date startDate,@PathVariable Date endDate) {

        return iContratService.nbContratsValides(startDate,endDate);
    }


    }
