package tn.OperationsMaintenance.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Equipement {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id; 
	String nom;
	@Enumerated(EnumType.STRING)
	private Etat etat;
	@OneToMany(mappedBy="equipement")
    private List<Panne> pannes = new ArrayList<>();
	@OneToMany(mappedBy ="equipement")
	private List<Intervention> interventions=new ArrayList<>();
	public enum Etat{
		Fonctionnel,en_panne,en_maintenance
	}
	
	


}

