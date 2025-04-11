package tn.OperationsMaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import tn.OperationsMaintenance.entity.Technicien;
import tn.OperationsMaintenance.entity.User;
import tn.OperationsMaintenance.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;

public UserController(UserService userService) {
	this.userService = userService;
}
@PostMapping("/ajout_technicien")
public ResponseEntity<User> addTechnician(@RequestBody Technicien technicien) {
    return ResponseEntity.ok(userService.addTechnician(technicien));
}
// Lister tous les techniciens
@GetMapping("/techniciens")
public ResponseEntity<List<Technicien>> getAllTechniciens()
		{    
    
    return ResponseEntity.ok(userService.getAllTechniciens());
}







/*@PutMapping("modifier/{id}")
public ResponseEntity<User> updateuser(@PathVariable int id,@RequestBody User user) {
    //TODO: process POST request
    
    return ResponseEntity.ok(userService.updateUser(id,user));
}

@DeleteMapping("delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
	    //TODO: process POST request
	    
	    return ResponseEntity.ok(userService.deleteUser(id));
	}
	
@GetMapping("/techniciens")
public ResponseEntity<List<User>> getAllTechniciens() {
    return ResponseEntity.ok(userService.getAllTechniciens());
}
*/
}


