package com.gradebook.Gradebook;

import com.gradebook.Gradebook.model.entity.*;
import com.gradebook.Gradebook.service.IAppUserService;
import com.gradebook.Gradebook.service.IParentService;
import com.gradebook.Gradebook.service.ISchoolClassService;
import com.gradebook.Gradebook.service.ISchoolService;
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
	CommandLineRunner runner(IAppUserService userService, IParentService parentService,
							 ISchoolService schoolService, ISchoolClassService schoolClassService) {

		return args ->{
			userService.saveUser(new AppUser(
					"admin",
					"admin_adminov@gmail.com",
					"$2a$10$n1042hx1F577X48aw9YdlO/hJUNYRKbZ5WtncghMYmUwK57ZL4Zte",
					RoleType.ADMIN,
					true));
			School s = new School("aaaaa", "A");
			schoolService.save(s);
			schoolClassService.save(new SchoolClass(
					null,
					"aaaaaa",
					SClass.FIFTH,
					s
			));
		};
	}
}
