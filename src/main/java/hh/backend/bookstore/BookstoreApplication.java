package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	// CREATE NEW LOGGER ATTRIBUTE
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner bookstoreAppRunner(BookRepository bookRepository, CategoryRepository catRepository) { 
		
		return (args) -> {


			// ADD TEST DATA: CATEGORIES

			Category cat1 = new Category(1, "Science Fiction");
			Category cat2 = new Category(2, "Fantasy");
			Category cat3 = new Category(3, "Biography");
			Category cat4 = new Category(4, "Textbook");

			catRepository.save(cat1);
			catRepository.save(cat2);
			catRepository.save(cat3);
			catRepository.save(cat4);
			
			// ADD THE TEST DATA: BOOKS
			log.info("In App: Save a couple of books");

			bookRepository.save(new Book("The Hobbit, or There and Back Again", "J. R. R. Tolkien", 1937L, "9780345445605", 25D, cat2));	
			bookRepository.save(new Book("The Quantum Thief", "Hannu Rajaniemi", 2010L, "0-575-08887-7", 21.95D, cat1));
			bookRepository.save(new Book("The Last Wish", "Andrzej Sapkowski", 1993L, "978-0-575-08244-1", 22D, cat1));
			bookRepository.save(new Book("Hyperion", "Dan Simmons", 1989L, "0-385-24949-7", 21D, cat1));

			



			// LOG THE INFO IMMEDIATELY FOR DEBUG
			// LOGGER IS GOOD: It can be TURNED ON FOR DEBUG, then TURNED OFF
			log.info("In app: Fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			log.info("In app: Fetch all categories");
			for (Category cat : catRepository.findAll()) {
				log.info(cat.toString());
			}
			log.info("In app: Fetching complete");

		};
	}

}
