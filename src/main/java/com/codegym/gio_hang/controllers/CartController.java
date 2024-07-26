package com.codegym.gio_hang.controllers;

import com.codegym.gio_hang.models.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public String showCart (@SessionAttribute(value = "cart",required = false) Cart cart, Model model){
        model.addAttribute("cart", cart);
        return "cartProduct";
    }
}
