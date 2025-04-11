package tn.OperationsMaintenance.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Technicien extends User {

	
    @ElementCollection
    private List<String> compétences; 
    private Boolean disponibilité;
	
	@OneToMany(mappedBy ="technicien")
	private List<Intervention> interventions=new ArrayList<>();
}
	