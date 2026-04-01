package com.example.DemoSecurity2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String listProducts(Model model) {
        // Giả lập danh sách sản phẩm để hiển thị lên giao diện
        List<String> products = Arrays.asList("Laptop Dell", "iPhone 15", "Bàn phím cơ");
        model.addAttribute("products", products);
        
        return "products"; // Trả về file products.html
    }
}