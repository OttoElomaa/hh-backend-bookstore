package hh.backend.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.CategoryRepository;





@Controller
public class BookController {

    List<Book> books = new ArrayList<Book>();

    //Book newBook = null;
    //Book selectedBook = null;


    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository catRepository;




    // BOOKLIST AND INDEX PAGES

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


    // FUNCTIONS ACTIVATED DURING THE ADDING OF NEW BOOKS IN BOOKLIST.HTML AND ADDBOOK.HTML

    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("newBook", new Book());
        model.addAttribute("categories", catRepository.findAll());
        return "addbook";
    }

    
    @PostMapping(value = "/savenew")
    public String saveNew(Book newBook){
        repository.save(newBook);
        return "redirect:/booklist";
    }
 

    // DELETE FUNCTION FOR BOOKS SELECTED IN BOOKLIST.HTML

    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }
 

    // FUNCTIONS ACTIVATED DURING THE EDITING OF BOOKS IN BOOKLIST.HTML AND EDITBOOK.HTML
    
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("selectedBook", repository.findById(bookId));
        model.addAttribute("categories", catRepository.findAll());
        return "editbook";
    }


    @PostMapping(value = "/savemodified")
        public String saveModified(Book newBook){
            repository.save(newBook);
            return "redirect:/booklist";
        }


}
