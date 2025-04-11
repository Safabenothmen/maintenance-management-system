package tn.OperationsMaintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.OperationsMaintenance.entity.Technicien;
import tn.OperationsMaintenance.entity.User;
import tn.OperationsMaintenance.entity.User.Role;

public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByNom(String nom);

	List<Technicien> findByRole(Role technicien);

}
