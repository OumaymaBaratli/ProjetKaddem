package tn.esprit.projectkaddem.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projectkaddem.entites.Departement;
import tn.esprit.projectkaddem.services.IDepartementService;

import java.util.List;
@Tag(name = "Departement Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("departement")
public class DepartementController {
    private  final IDepartementService iDepartementService;

    @GetMapping
    public List<Departement> getAll(){
        return  iDepartementService.getAllDepartement();
    }

    @GetMapping("/{id}")
    public Departement get(@PathVariable Integer id){
        return iDepartementService.GetDepartementById(id);
    }

    @PostMapping
    public void add(@RequestBody Departement d){
        iDepartementService.ajouteDepartement(d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        iDepartementService.deleteDepartement(id);
    }
}
