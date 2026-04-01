package com.example.demosecuritycoban;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/login") // Giữ lại ở đây là đủ
    public String login() {
        return "login"; 
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<String> stocks = Arrays.asList("Giá Xăng - 54.200", "Giá Vàng - 18.332.500", "Giá Đạn - 45.100");
        model.addAttribute("stocks", stocks);
        return "products"; 
    }
}