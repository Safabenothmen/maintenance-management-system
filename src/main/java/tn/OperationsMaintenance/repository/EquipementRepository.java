package tn.OperationsMaintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.OperationsMaintenance.entity.Equipement;
import java.util.List;


public interface EquipementRepository extends JpaRepository<Equipement, Integer> {
Equipement findByNom(String nom);
Equipement findById(int id);}
