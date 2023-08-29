package controller;


import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductService;

@Controller
public class Home {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "home";
    }

    @GetMapping("/products/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "edit";
    }

    @PostMapping("/products/edit")
    public String edit(@RequestParam int id, String name, String img, int price) {
        productService.edit(new Product(id, price, name, img));
        return "redirect:/products";
    }

    @GetMapping("/products/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/products/add")
    public String showadd() {
        return "add";
    }

    @PostMapping("/products/add")
    public String add(@RequestParam  int price, String name, String img) {
        productService.add(new Product( price, name, img));
        return "redirect:/products";
    }

    @GetMapping("/products/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.findByNameI(name));
        return "home";
    }
}