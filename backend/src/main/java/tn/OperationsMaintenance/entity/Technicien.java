package tn.OperationsMaintenance.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Table(name = "technicien") 

@Data
//@EqualsAndHashCode(callSuper = true)
public class Technicien  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int  id;
    
    private String nom;
    private String email;

    private String mdp;

    private String competences; 
    private Boolean disponibilite;
	
	@OneToMany(mappedBy ="technicien")
	@JsonManagedReference("technicien-interventions")

	private List<Intervention> interventions=new ArrayList<>();
}
	