package com.gradebook.Gradebook;

import com.gradebook.Gradebook.model.entity.AppUser;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.service.IAppUserService;
import com.gradebook.Gradebook.service.IParentService;
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

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

	@Bean
	CommandLineRunner runner(IAppUserService userService, IParentService parentService) {

		return args ->{
			 userService.saveUser(new AppUser(
					"user",
					"stoqn_stoqnov@gmail.com",
					"$2a$10$n1042hx1F577X48aw9YdlO/hJUNYRKbZ5WtncghMYmUwK57ZL4Zte",
					RoleType.TEST,
					true));
		};


	}
}
