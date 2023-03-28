package com.myblog.blogapp;

import com.myblog.blogapp.entities.Role;
import com.myblog.blogapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication             //implements CommandLineRunner
public class BlogappApplication  {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {

		SpringApplication.run(BlogappApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Role adminRole = new Role();
//		adminRole.setName("ROLE_ADMIN");
//		roleRepository.save(adminRole);
//
//		Role userRole = new Role();
//		userRole.setName("ROLE_USER");
//		roleRepository.save(userRole);
//
//	}
}
