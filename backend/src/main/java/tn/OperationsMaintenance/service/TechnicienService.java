package tn.OperationsMaintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.OperationsMaintenance.entity.Technicien;
//import tn.OperationsMaintenance.entity.User.Role;
import tn.OperationsMaintenance.repository.TechnicienRepository;
//import tn.OperationsMaintenance.repository.UserRepository;
@Service
public class TechnicienService {
@Autowired
private TechnicienRepository technicienRepository;
//private UserRepository userRepository;

//ajout technicien 

public Technicien AjoutTechnicien(Technicien technicien) {
	return technicienRepository.save(technicien);
}
public List<Technicien> GetALLTechniciens(){
	return technicienRepository.findAll();
}

public Technicien suprimerTechnicien(int id) {
    Optional<Technicien> technicien = technicienRepository.findById(id);
    if (technicien.isPresent()) {
        Technicien t = technicien.get();
        technicienRepository.deleteById(id);
        return t;
    }
    return null; 
}
public List<Technicien> getTechniciensDisponibles(){
    return technicienRepository.findByDisponibiliteTrue();
}


//modifier techncien
 public Technicien modifierTechnicien(int id ,Technicien newTechnicien) {
	 
     Technicien technicien = technicienRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Technicien non trouvé"));
			 technicien.setCompetences(newTechnicien.getCompetences());
			 technicien.setDisponibilite(newTechnicien.getDisponibilite());
		        return technicienRepository.save(technicien);

 }
 

}
