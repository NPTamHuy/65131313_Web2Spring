package com.example.OntapGK.controllers;

import com.example.OntapGK.models.tintuc;
import com.example.OntapGK.service.TinTucService;
import com.example.OntapGK.service.LoaiTinTucService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller 
@RequestMapping("/admin") 
public class AdminController {

    private final TinTucService tinTucService;
    private final LoaiTinTucService loaiTinTucService;

    public AdminController(TinTucService tinTucService, LoaiTinTucService loaiTinTucService) {
        this.tinTucService = tinTucService;
        this.loaiTinTucService = loaiTinTucService;
    }

    @GetMapping("")
    public String adminIndex(Model model) {
        model.addAttribute("danhSachTin", tinTucService.getAllTinTuc());
        return "admin";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tin", new tintuc());
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "add-edit";
    }

    @PostMapping("/save")
    public String saveTin(@ModelAttribute("tin") tintuc tin) {
        tinTucService.saveTinTuc(tin);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteTin(@PathVariable("id") Integer id) {
        tinTucService.deleteTinTuc(id);
        return "redirect:/admin";
    }
}