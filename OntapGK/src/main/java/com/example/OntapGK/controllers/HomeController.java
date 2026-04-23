package com.example.OntapGK.controllers;

import com.example.OntapGK.service.TinTucService;
import com.example.OntapGK.service.LoaiTinTucService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final TinTucService tinTucService;
    private final LoaiTinTucService loaiTinTucService;

    public HomeController(TinTucService tinTucService, LoaiTinTucService loaiTinTucService) {
        this.tinTucService = tinTucService;
        this.loaiTinTucService = loaiTinTucService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "index"; 
    }

    @GetMapping("/tin-tuc/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        return "detail"; 
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String user, 
                              @RequestParam("password") String pass, 
                              Model model) {
        if ("admin".equals(user) && "123".equals(pass)) {
            return "redirect:/admin";
        }
        
        model.addAttribute("error", true);
        return "login";
    }
}