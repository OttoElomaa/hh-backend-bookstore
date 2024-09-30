package hh.backend.bookstore.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// EXTENDS CrudRepository, THEN BookController WILL CREATE
// A NEW Hibernate OBJECT THAT IMPLEMENTS
// THE BookRepository INTERFACE

// TRY: http://localhost:8080/api/books/search/findByTitle?title=Hyperion

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(@Param("title") String title);
    }


