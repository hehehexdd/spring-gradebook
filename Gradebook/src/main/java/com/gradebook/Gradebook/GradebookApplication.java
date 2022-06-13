package com.gradebook.Gradebook;

import com.gradebook.Gradebook.data.entity.AppUser;
import com.gradebook.Gradebook.data.entity.Role;
import com.gradebook.Gradebook.data.entity.RoleType;
import com.gradebook.Gradebook.data.service.AppUserService;
import com.gradebook.Gradebook.data.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GradebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradebookApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	CommandLineRunner runner(AppUserService userService, RoleService roleService) {
		return args -> {
			Role testRole = new Role("Test");
			roleService.saveRole(testRole);
			userService.saveUser(new AppUser(
					"user",
					"stoqn_stoqnov@gmail.com",
					"123",
					testRole,
					true));
		};
	}
}
