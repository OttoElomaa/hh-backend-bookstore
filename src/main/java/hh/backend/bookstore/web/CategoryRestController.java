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
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;




@RestController
public class CategoryRestController {


	@Autowired
	private CategoryRepository crepository;


	@GetMapping(value="/categories/{id}")
	public @ResponseBody Optional<Category> getOneCategory(@PathVariable(name="categoryId") Long catId) {

		return crepository.findById(catId);
	}

	@GetMapping(value="/categories")
	public @ResponseBody Iterable<Category> getAllBooks() {

		return crepository.findAll();
	}
}

