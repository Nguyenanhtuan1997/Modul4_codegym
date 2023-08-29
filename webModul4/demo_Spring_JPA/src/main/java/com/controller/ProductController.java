package com.controller;

import com.model.Category;
import com.model.Product;
import com.service.ICategoryService;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.getAll();
    }

    @GetMapping
    public ModelAndView home( ){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Product> products = productService.getAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String create(@ModelAttribute Product product){
        productService.edit(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public ModelAndView showadd(){
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/products";
    }
}