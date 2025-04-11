package tn.OperationsMaintenance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    
    private String nom;
    private String mdp;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN ou TECHNICIEN

    public enum Role{
    	Admin,Technicien
    }
}

