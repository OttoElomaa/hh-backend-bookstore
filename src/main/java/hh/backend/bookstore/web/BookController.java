package hh.backend.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.backend.bookstore.domain.Book;

@Controller
public class BookController {

    List<Book> books = new ArrayList<Book>();


    @GetMapping(value = "/index")
    public String friendListMethod(Model model) {

        model.addAttribute("book", new Book());

        //friends.add(new Student("Otto", "Elomaa"));
        model.addAttribute("books", books);

        return "index";
    }
}
