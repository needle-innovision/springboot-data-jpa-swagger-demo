package com.needle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.github.javafaker.Faker;
import com.needle.model.Book;
import com.needle.repository.BookRepository;

/**
 * A sample runner class
 * 
 * @author sandeepknair
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class SwaggerTestApplication {

	private final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(SwaggerTestApplication.class, args);
	}

	/**
	 * Command line runner that initializes the repository data
	 * 
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner initializeDb(BookRepository repository) {
		return (args) -> {
			repository.deleteAll();
			// Insert some random pies
			for (int i = 0; i < 20; i++) {
				repository.save(new Book(faker.lorem().word(), faker.lorem().sentence()));
			}
		};
	}

	

}
