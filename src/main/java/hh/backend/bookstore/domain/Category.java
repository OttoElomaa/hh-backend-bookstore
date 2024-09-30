package hh.backend.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import hh.backend.bookstore.domain.Book;


@Entity
public class Category {

 	// PRIMARY KEY OF "TABLE" == ENTITY
    // ENTITY INTERFACES WITH THE ACTUAL TABLE IN DATABASE
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;

	private String name;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="category")
	private List<Book> books = new ArrayList<Book>();


	public Category(String name) {
		this.name = name;
	}
	
	public Category() {
	}

	

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}



	

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", books amount: ]";
	}
	
	



}
