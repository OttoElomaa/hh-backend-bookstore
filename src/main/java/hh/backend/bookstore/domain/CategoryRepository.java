package hh.backend.bookstore.domain;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

    // EXTENDS CrudRepository, THEN BookController WILL CREATE
    // A NEW Hibernate OBJECT THAT IMPLEMENTS
    // THE BookRepository INTERFACE

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByName(@Param("name") String name);
}

