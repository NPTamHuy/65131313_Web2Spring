package com.example.QuanLyBanHangMNK.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // Trả về tên file index.html trong thư mục templates
        return "index";
    }
}
