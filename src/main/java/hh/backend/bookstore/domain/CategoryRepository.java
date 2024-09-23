package hh.backend.bookstore.domain;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import hh.backend.bookstore.domain.Category;

    // EXTENDS CrudRepository, THEN BookController WILL CREATE
    // A NEW Hibernate OBJECT THAT IMPLEMENTS
    // THE BookRepository INTERFACE
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	List<Category> findByName(String name);
	}

