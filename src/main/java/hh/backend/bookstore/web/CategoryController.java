package hh.backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.backend.bookstore.domain.CategoryRepository;


@Controller
public class CategoryController {


	@Autowired
    private CategoryRepository repository;

   @RequestMapping(value= "/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }
}
