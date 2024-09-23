package hh.backend.bookstore.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

    // EXTENDS CrudRepository, THEN BookController WILL CREATE
    // A NEW Hibernate OBJECT THAT IMPLEMENTS
    // THE BookRepository INTERFACE
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    }


