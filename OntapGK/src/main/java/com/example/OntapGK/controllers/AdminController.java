package com.example.OntapGK.controllers;

import com.example.OntapGK.models.tintuc;
import com.example.OntapGK.models.loaitintuc;
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

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("danhSachLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "admin-loai-tin";
    }

    @GetMapping("/categories/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("loaiTin", new loaitintuc());
        return "add-category";
    }

    @PostMapping("/categories/save")
    public String saveCategory(@ModelAttribute("loaiTin") loaitintuc loaiTin) {
        loaiTinTucService.saveLoaiTinTuc(loaiTin);
        return "redirect:/admin/categories";
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

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
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