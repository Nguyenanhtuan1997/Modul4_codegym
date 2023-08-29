package com.demospringmvc.controller;

import com.demospringmvc.model.Category;
import com.demospringmvc.model.Product;
import com.demospringmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class Home {
    @Autowired
    ProductService productService;

    @ModelAttribute(name = "categories")
    public List<Category> categories() {
        return productService.categories;
    }

    @GetMapping
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.products);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String showEdit2(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, @RequestParam int idCategory) {
        Category category = productService.findCategoryById(idCategory);
        product.setCategory(category);
        productService.edit(product);
        return "redirect:/products";
    }

    @PostMapping("/create")
    public String create(@RequestParam MultipartFile fileImg, @ModelAttribute Product product, @RequestParam int idCategory) {
        try {
            String nameFile = fileImg.getOriginalFilename();
            fileImg.transferTo(new File("D:\\Java\\Modul 3\\web\\webModul4\\demo_SpringMVC_Module4_C0423h1\\src\\main\\webapp\\img\\" + nameFile));

            Category category = productService.findCategoryById(idCategory);
            product.setCategory(category);
            product.setImg(nameFile);
            productService.products.add(product);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/products";
    }

    public String home() {
        return "home";
    }
}
