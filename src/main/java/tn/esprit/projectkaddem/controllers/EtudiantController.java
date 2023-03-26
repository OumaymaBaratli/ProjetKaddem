package tn.esprit.projectkaddem.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectkaddem.entites.Etudiant;
import tn.esprit.projectkaddem.services.IEtudiantService;

import java.util.List;

@Tag(name = "Etudiant Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("etudiant")
public class EtudiantController {
    private final IEtudiantService iEtudiantService;

    @GetMapping
    public List<Etudiant> getAll() {
        return iEtudiantService.getAllEtudiant();
    }

    @GetMapping("/{id}")
    public Etudiant get(@PathVariable Integer id) {
        return iEtudiantService.getEtudiantById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        iEtudiantService.deleteEtudiant(id);
    }

    @PutMapping
    public void update(@RequestBody Etudiant e) {
        iEtudiantService.updateEtudiant(e);
    }

    @PostMapping
    public void add(@RequestBody Etudiant e) {
        iEtudiantService.ajouteEtudiant(e);
    }

    @PutMapping("/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable Integer etudiantId, @PathVariable Integer departementId) {
        iEtudiantService.assignEtudiantToDepartement(etudiantId, departementId);
    }
    @PostMapping("/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable Integer idContrat, @PathVariable Integer idEquipe) {
       return  iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer idDepartement) {
        return iEtudiantService.getEtudiantsByDepartement(idDepartement);
    }

    }
