package tn.OperationsMaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.OperationsMaintenance.entity.Technicien;
import tn.OperationsMaintenance.service.TechnicienService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@Controller

public class TechnicienController {
    @Autowired

private TechnicienService technicienService;

public TechnicienController(TechnicienService technicienService) {
	this.technicienService = technicienService;
}

@PostMapping("technicien/ajout")
public ResponseEntity<Technicien> AjoutTechnicien(@RequestBody Technicien technicien){
return ResponseEntity.ok(technicienService.AjoutTechnicien(technicien));

}

@GetMapping("/techniciens")
public ResponseEntity<List<Technicien>> GetALLTechniciens(){
    return ResponseEntity.ok(technicienService.GetALLTechniciens());
}

@DeleteMapping("/supprimerTechnicien/{id}")
public Technicien supprimerTechnicien(@PathVariable int id) {
    return technicienService.suprimerTechnicien(id);
}

@GetMapping("/technciens/{id}")
public String getMethodName(@RequestParam String param) {
    return new String();
}

@GetMapping("/techniciens/disponibles")
public ResponseEntity<List<Technicien>> getTechniciensDisponibles() {
    return ResponseEntity.ok(technicienService.getTechniciensDisponibles());
}
//modifieTechncien
@PutMapping("/Modifiertechnicien/{id}")
public ResponseEntity<Technicien> modifierTechnicien(@PathVariable int id, @RequestBody Technicien technicien) {
    //TODO: process PUT request
	return ResponseEntity.ok(technicienService.modifierTechnicien(id, technicien));
    
}



}


