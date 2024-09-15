package hh.backend.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;





@Controller
public class BookController {

    List<Book> books = new ArrayList<Book>();
    Book newBook = null;


    @Autowired
    private BookRepository repository;


    @RequestMapping(value= "/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }



    @GetMapping(value = {"/","/index"})
    public String indexMethod(Model model) {

        model.addAttribute("book", new Book());
        model.addAttribute("books", books);

        return "index";
    }



    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("newBook", new Book());
        return "addbook";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book newBook){
        repository.save(newBook);
        return "redirect:/booklist";
    }
 

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }
 


}
