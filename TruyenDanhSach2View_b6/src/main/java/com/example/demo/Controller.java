package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @GetMapping("/bai6")
    public String hienThiDiem(ModelMap model) {
        List<SinhVien> danhSach = new ArrayList<>();
        
        danhSach.add(new SinhVien("Nguyễn Phúc Tâm Huy", 2005, 7.0));
        danhSach.add(new SinhVien("Phan Sĩ Thành", 2005, 8.5)); 
        danhSach.add(new SinhVien("Phạm Minh Quang", 2005, 8.0));
        danhSach.add(new SinhVien("Lê Trung Kiên", 2005, 6.0));

        
        model.addAttribute("ds", danhSach);
        
        return "bangdiem";
    }
}
