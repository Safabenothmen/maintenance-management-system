package tn.OperationsMaintenance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tn.OperationsMaintenance.entity.Panne;
import tn.OperationsMaintenance.repository.PanneRepository;

@Service
public class PanneService {
private final PanneRepository panneRepository;

public PanneService(PanneRepository panneRepository) {
    this.panneRepository = panneRepository;
}

//create
public Panne ajouterPanne(Panne panne) {
    return panneRepository.save(panne);
}

//modifer 
public Panne modifierPanne(int id, Panne nouvellePanne) {
    return panneRepository.findById(id)
            .map(panne -> {  // Si l'objet est présent, on l'update
                panne.setDescription(nouvellePanne.getDescription());
                panne.setCategorie(nouvellePanne.getCategorie());
                panne.setDate_sign(nouvellePanne.getDate_sign());
                panne.setEquipement(nouvellePanne.getEquipement());
                return panneRepository.save(panne);  // On sauvegarde et retourne l'entité modifiée
            })
            .orElseThrow(() -> new RuntimeException("Panne non trouvée avec l'ID : " + id)); 
}


//supprimer
public void supprimerPanne(int id) {
	panneRepository.deleteById(id);
}

//consulter  tous les pannes
public List<Panne> getAllPannes() {
    return panneRepository.findAll();
}

//consulter panne par id
public Optional<Panne> getPanneById(int id) {
	return panneRepository.findById(id);
}

}
