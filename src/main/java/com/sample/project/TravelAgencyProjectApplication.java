package com.sample.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelAgencyProjectApplication {
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {

		SpringApplication.run(TravelAgencyProjectApplication.class, args);
	}
//
//	/**
//	 * Password grants are switched on by injecting an AuthenticationManager.
//	 * Here, we setup the builder so that the userDetailsService is the one we coded.
//	 * @param builder
//	 * @param repository
//	 * @throws Exception
//	 */
//	@Autowired
//	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService userService) throws Exception {
//		if (repository.count()==0)
//			userService.save(new User("admin", "adminPassword", Arrays.asList(new Role("USER"), new Role("ACTUATOR") , new Role("ADMIN"))));
//		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
//	}
//
//	/**
//	 * We return an istance of our CustomUserDetails.
//	 * @param repository
//	 * @return
//	 */
//	private UserDetailsService userDetailsService(final UserRepository repository) {
//		return username -> new CustomUserDetails(repository.findByUsername(username));
//	}
}
