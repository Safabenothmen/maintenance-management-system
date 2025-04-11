package tn.OperationsMaintenance.entity;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Intervention {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;


@ManyToOne
@JoinColumn(name="idEquipement")
private Equipement equipement;

@ManyToOne
@JoinColumn(name="idTechnicien")
private Technicien technicien ;
@Enumerated(EnumType.STRING)
private Statut statut;

private Date date;
private float cout;
private enum Statut{
	Planifiee,En_cours,Terminee,Annulee
}

}





