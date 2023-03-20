package fi.project.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.project.Bookstore.domain.Book;
import fi.project.Bookstore.domain.BookRepository;
import fi.project.Bookstore.domain.Category;
import fi.project.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JPAtesting {

	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private BookRepository brepository;
	

	 @Test
	 public void findAllShouldReturnBooksandCategorys() {
		 Iterable<Category> categorys = crepository.findAll();
		 List<Book> books = brepository.findAll();
		 assertThat(books).hasSize(2);
		 assertThat(books.get(0).getTitle()).isEqualTo("A Farewell to Arms");
		 
		 assertThat(categorys).hasSize(2);
		 assertThat(((List<Category>) categorys).get(0).getName()).isEqualTo("Realism");
		 
	 }
	 
	 @Test
	 public void createNewBookAndCategory() {
		 Book book = new Book("Test", "Test", "1993", "123123", "15,15", new Category("Test"));
		 brepository.save(book);
		 assertThat(book.getId()).isNotNull();
		 
		 Category category = new Category("Test");
		 crepository.save(category);
		 assertThat(category.getId()).isNotNull();
	 }
	
	 @Test
	 public void deleteBookAndCategory() {
		 brepository.deleteAll();
		 assertThat(brepository.findAll()).isEmpty();
		 crepository.deleteAll();
		 assertThat(crepository.findAll()).isEmpty();
	 }
}
