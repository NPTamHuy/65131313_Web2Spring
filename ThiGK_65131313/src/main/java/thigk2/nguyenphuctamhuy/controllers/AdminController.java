package thigk2.nguyenphuctamhuy.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thigk2.nguyenphuctamhuy.models.TinTuc;
import thigk2.nguyenphuctamhuy.services.LoaiTinTucService;
import thigk2.nguyenphuctamhuy.services.TinTucService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TinTucService tinTucService;
    @Autowired
    private LoaiTinTucService loaiTinTucService;

    private boolean isNotLoggedIn(HttpSession session) {
        return session.getAttribute("user") == null;
    }

    @GetMapping("")
    public String quanLyTin(HttpSession session, Model model) {
        if (isNotLoggedIn(session)) return "redirect:/login";
        model.addAttribute("dsTinTuc", tinTucService.getAllTinTuc());
        return "admin";
    }

    @GetMapping("/add")
    public String formThem(HttpSession session, Model model) {
        if (isNotLoggedIn(session)) return "redirect:/login";
        model.addAttribute("tin", new TinTuc());
        model.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "updateTinTuc";
    }

    @GetMapping("/edit/{id}")
    public String formSua(@PathVariable("id") int id, HttpSession session, Model model) {
        if (isNotLoggedIn(session)) return "redirect:/login";
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        model.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "updateTinTuc";
    }

    @PostMapping("/save")
    public String luuTin(@ModelAttribute("tin") TinTuc tin, HttpSession session) {
        if (isNotLoggedIn(session)) return "redirect:/login";
        tinTucService.saveTinTuc(tin);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String xoaTin(@PathVariable("id") int id, HttpSession session) {
        if (isNotLoggedIn(session)) return "redirect:/login";
        tinTucService.deleteTinTuc(id);
        return "redirect:/admin";
    }
}