package thigk2.nguyenphuctamhuy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thigk2.nguyenphuctamhuy.models.LoaiTinTuc;
import thigk2.nguyenphuctamhuy.models.TinTuc;
import thigk2.nguyenphuctamhuy.services.LoaiTinTucService;
import thigk2.nguyenphuctamhuy.services.TinTucService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsRestController {
    @Autowired
    private LoaiTinTucService loaiTinTucService;
    @Autowired
    private TinTucService tinTucService;

    @GetMapping("/the-loai")
    public List<LoaiTinTuc> getAllCategories() {
        return loaiTinTucService.getAllLoaiTinTuc();
    }

    @GetMapping("/tin-theo-loai/{idLoai}")
    public List<TinTuc> getNewsByCategory(@PathVariable("idLoai") int idLoai) {
        return tinTucService.getTinTucByLoai(idLoai);
    }
}