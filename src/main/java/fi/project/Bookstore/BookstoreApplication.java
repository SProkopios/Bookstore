package fi.project.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.project.Bookstore.Models.Book;
import fi.project.Bookstore.Models.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {return (args) -> {
	 Book firstBook = new Book("A Farewell to Arms", "Ernest Hemingway", "1929", "1232323-21", 12.23);
	 Book secondBook = new Book("Animal Farm", "George Orwell", "1945", "2212343-5", 15.50);
	 
	 repository.save(firstBook);
	 repository.save(secondBook);
	};
	}
}
