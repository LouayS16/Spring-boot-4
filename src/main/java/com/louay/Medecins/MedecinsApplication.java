package com.louay.Medecins;

//import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.louay.Medecins.entities.Medecin;

import com.louay.Medecins.entities.User;
import com.louay.Medecins.service.UserService;

import jakarta.annotation.PostConstruct;
//import com.louay.Medecins.service.AvionService;

@SpringBootApplication
public class MedecinsApplication implements CommandLineRunner {
/*
	@Autowired
	AvionService avionService;
*/
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MedecinsApplication.class, args);
	}
/*
	@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"souleimen","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("souleimen", "USER");
	userService.addRoleToUser("souleimen", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}
*/
	
	@Override
	public void run(String... args) throws Exception {
		
		 //System.out.println("Password Encoded BCRYPT :******************** ");
		 //System.out.println(passwordEncoder.encode("123"));

				
		/*
		avionService.saveAvion(new Avion("Boeing233", 5422600, new Date()));
		avionService.saveAvion(new Avion("Airline231", 212800, new Date()));
		avionService.saveAvion(new Avion("Skyflight242", 1119900, new Date()));
		*/
	
		repositoryRestConfiguration.exposeIdsFor(Medecin.class);

}
}