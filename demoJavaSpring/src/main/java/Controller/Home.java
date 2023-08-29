package Controller;

import Model.Product;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class Home {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String home(Model model){
        model.addAttribute("products",productService.products);
        return "home";
    }
    @GetMapping("/products/search")
    public String search(String name, Model model) throws SQLException {
        model.addAttribute("products" , productService.findByName(name));
        return "home";
    }
    @GetMapping("/products/edit")
    public String showEdit(@RequestParam int id ,Model model){
      model.addAttribute("product",productService.findById(id));
      return "edit";
    }
    @GetMapping("/products/add")
    public String showAdd(){
        return "add";
    }

    @PostMapping("/products/edit")
    public String edit(@RequestParam int id, String name , double price , String image){
        productService.edit(new Product(id , name , price , image));
        return "redirect:/products";
    }

    @GetMapping("/products/delete")
    public String delete(@RequestParam int id){
        productService.delete(id);
        return "redirect:/products";
    }
    @PostMapping("/products/add")
    public String add(@RequestParam int id , String name , double price , String image){
        productService.add(new Product(id,name,price,image));
        return "redirect:/products";
    }
}