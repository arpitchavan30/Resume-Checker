package com.example.Job.Seeker.Application;

import com.example.Job.Seeker.Application.auth.AuthenticationService;
import com.example.Job.Seeker.Application.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.example.Job.Seeker.Application.controller.Role.ADMIN;
import static com.example.Job.Seeker.Application.controller.Role.CLIENT;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JobSeekerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSeekerApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var client = RegisterRequest.builder()
					.firstname("Client")
					.lastname("Client")
					.email("Client@mail.com")
					.password("password")
					.role(CLIENT)
					.build();
			System.out.println("Client token: " + service.register(client).getAccessToken());

		};
	}
}
