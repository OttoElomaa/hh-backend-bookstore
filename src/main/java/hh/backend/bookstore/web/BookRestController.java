package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;




@RestController
public class BookRestController {


	@Autowired
	private BookRepository brepository;


	@GetMapping(value="/books/{id}")
	public @ResponseBody Optional<Book> getOneBook(@PathVariable(name="id") Long bookId) {

		return brepository.findById(bookId);
	}

	@GetMapping(value="/books")
	public @ResponseBody Iterable<Book> getAllBooks() {

		return brepository.findAll();
	}
}
