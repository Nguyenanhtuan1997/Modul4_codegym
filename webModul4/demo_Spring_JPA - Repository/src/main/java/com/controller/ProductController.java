package com.controller;

import com.dao.ProductDAO;
import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Product> products =  productDAO.getAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productDAO.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String create(@ModelAttribute Product product){
        productDAO.edit(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productDAO.delete(productDAO.findById(id));
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
        productDAO.save(product);
        return "redirect:/products";
    }
}