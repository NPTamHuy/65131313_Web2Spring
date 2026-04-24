package thigk2.nguyenphuctamhuy.ontap2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thigk2.nguyenphuctamhuy.ontap2.models.LoaiSanPham;
import thigk2.nguyenphuctamhuy.ontap2.models.SanPham;
import thigk2.nguyenphuctamhuy.ontap2.service.LoaiSanPhamService;
import thigk2.nguyenphuctamhuy.ontap2.service.SanPhamService;

import java.util.List;

@RestController
public class RController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @GetMapping("/testAPISanPham")
    public List<SanPham> getAllSanPham() {
        return sanPhamService.getAllSanPham();
    }

    @GetMapping("/testAPILoaiSanPham")
    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamService.getAllLoaiSanPham();
    }
}