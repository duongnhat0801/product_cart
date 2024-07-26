package com.codegym.gio_hang.controllers;

import com.codegym.gio_hang.models.Cart;
import com.codegym.gio_hang.models.Product;
import com.codegym.gio_hang.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("home")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productList";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute(value = "cart",required = false) Cart cart,
                            @RequestParam("action") String action,
                            Model model) {
        Product product = productService.getProductById(id);
        if (action.equals("add")) {
            cart.addProduct(productService.getProductById(id));
            model.addAttribute("products", productService.getProductById(id));
            model.addAttribute("cart", cart);
            return "redirect:/shopping-cart";
        } else if (action.equals("reduce")) {
            cart.reduceProduct(productService.getProductById(id));
            model.addAttribute("products", productService.getProductById(id));
            model.addAttribute("cart", cart);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productService.getProductById(id));
        model.addAttribute("products", productService.getProductById(id));

        model.addAttribute("cart", cart);
        return "redirect:/home";

    }

}
