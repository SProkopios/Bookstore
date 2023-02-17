package fi.project.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.project.Bookstore.domain.Book;
import fi.project.Bookstore.domain.BookRepository;
import fi.project.Bookstore.domain.Category;
import fi.project.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {return (args) -> {
	 
     Category realism = new Category("Realism");
     Category satire = new Category("Political satire");
     crepository.save(realism);
     crepository.save(satire);
     
	 Book firstBook = new Book("A Farewell to Arms", "Ernest Hemingway", "1929", "1232323-21", "12.23", realism);
	 Book secondBook = new Book("Animal Farm", "George Orwell", "1945", "2212343-5", "15.50", satire);
	 
	 repository.save(firstBook);
	 repository.save(secondBook);
     
     
	};
	}
}
