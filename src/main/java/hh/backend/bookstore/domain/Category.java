package hh.backend.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Category {

 	// PRIMARY KEY OF "TABLE" == ENTITY
    // ENTITY INTERFACES WITH THE ACTUAL TABLE IN DATABASE
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;

	private String name;


	public Category(int categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}
	public Category() {
	}

	

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}

	

	
	



}
