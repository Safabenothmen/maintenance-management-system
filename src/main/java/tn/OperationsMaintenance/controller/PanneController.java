package tn.OperationsMaintenance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.OperationsMaintenance.entity.Panne;
import tn.OperationsMaintenance.service.PanneService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController	
@RequestMapping("/panne")
public class PanneController {
	@Autowired
    private final PanneService panneService;
    
    public PanneController(PanneService panneService) {
        this.panneService = panneService;
    }
    @PostMapping("/ajouter")
    public Panne ajouterPanne(@RequestBody Panne panne) {
        return panneService.ajouterPanne(panne);
    }
    @PutMapping("modifer/{id}")
    public Panne modifierPanne(@PathVariable int id, @RequestBody Panne nouvellePanne) {
        return panneService.modifierPanne(id, nouvellePanne);
    }
    
    @DeleteMapping("supprimer/{id}")
     
    	public void supprimerPanne(@PathVariable int id) {
     panneService.supprimerPanne(id);
    }
   
    @GetMapping("/all")
	public List<Panne> getAllPannes(){
	
	return panneService.getAllPannes();
	}
   
   @GetMapping("/{id}")
   public Optional<Panne> getPanneById(@PathVariable int id)
   {
	   return panneService.getPanneById(id);
   }
}


