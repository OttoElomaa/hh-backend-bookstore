package hh.backend.bookstore.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 
@Entity
public class Book {

    // PRIMARY KEY OF "TABLE" == ENTITY
    // ENTITY INTERFACES WITH THE ACTUAL TABLE IN DATABASE
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String title;
    public String author;
    public Long publicationYear;
    public String isbn;
    public Double price;




    public Book(String title, String author, Long publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
    }




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Long getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Long publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }




    



    




    

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }

 


}
