package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner carDemo(BookRepository bookRepository) { 
		return (args) -> {

			

			log.info("save a couple of cars");
			Book book1 = new Book("Title", "Author", 1990L, "Isbn", 0D);
			bookRepository.save(book1);

			bookRepository.save(new Book("Title", "Author", 1992L, "Isbn", 0D));	
			bookRepository.save(new Book("The Quantum Thief", "Hannu Rajaniemi", 2010L, "0-575-08887-7", 21.95D));
			bookRepository.save(new Book("Title", "Author", 1992L, "Isbn", 0D));
			bookRepository.save(new Book("Title", "Author", 1992L, "Isbn", 0D));

			log.info("fetch all cars");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
