package thigk2.nguyenphuctamhuy.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thigk2.nguyenphuctamhuy.services.LoaiTinTucService;
import thigk2.nguyenphuctamhuy.services.TinTucService;
import thigk2.nguyenphuctamhuy.services.UserService;
import thigk2.nguyenphuctamhuy.models.User;

@Controller
public class HomeController {
    @Autowired
    private TinTucService tinTucService;
    @Autowired
    private LoaiTinTucService loaiTinTucService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String trangChu(Model model) {
        model.addAttribute("dsTinTuc", tinTucService.getAllTinTuc());
        model.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "index";
    }

    @GetMapping("/the-loai/{id}")
    public String tinTheoLoai(@PathVariable("id") int id, Model model) {
        model.addAttribute("dsTinTuc", tinTucService.getTinTucByLoai(id));
        model.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        model.addAttribute("loaiHienTai", loaiTinTucService.getLoaiTinTucById(id));
        return "index";
    }

    @GetMapping("/chi-tiet/{id}")
    public String chiTietTin(@PathVariable("id") int id, Model model) {
        model.addAttribute("tin", tinTucService.getTinTucById(id));
        model.addAttribute("dsLoai", loaiTinTucService.getAllLoaiTinTuc());
        return "detail";
    }

    @GetMapping("/login")
    public String trangDangNhap() {
        return "login";
    }

    @PostMapping("/login")
    public String thucHienDangNhap(@RequestParam String username, @RequestParam String password, 
                                  HttpSession session, Model model) {
        User user = userService.verifyLogin(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/admin";
        }
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
        return "login";
    }

    @GetMapping("/logout")
    public String dangXuat(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}