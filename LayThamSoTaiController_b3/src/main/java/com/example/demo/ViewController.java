package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class ViewController {
	 @GetMapping("/bai3")
	    public String hienThiTrangNhap() {
	        return "NhapThongTin"; 
	    }

	    @PostMapping("/xuly")
	    public String xuLyDuLieu(

	            @RequestParam("HT") String ten,
	            @RequestParam("NS") int namSinh,
	            @RequestParam("Ma") String lop,
	            @RequestParam("GT") String truong,
	            ModelMap model
	    ) {

	        model.addAttribute("tenHS", ten);
	        model.addAttribute("namSinhHS", namSinh);
	        model.addAttribute("lopHS", lop);
	        model.addAttribute("truongHS", truong);
	        return "ketqua"; 
	    }

}
