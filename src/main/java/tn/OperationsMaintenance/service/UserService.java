package tn.OperationsMaintenance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.OperationsMaintenance.entity.Technicien;
import tn.OperationsMaintenance.entity.User;
import tn.OperationsMaintenance.repository.UserRepository;

@Service
public class UserService {
private UserRepository userRepository;

public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
}
public User addTechnician(Technicien technicien) {
    technicien.setRole(User.Role.Technicien);
    return userRepository.save(technicien);
}

//Lister tous les techniciens
public List<Technicien> getAllTechniciens() {
    return userRepository.findByRole(User.Role.Technicien);
}
}
