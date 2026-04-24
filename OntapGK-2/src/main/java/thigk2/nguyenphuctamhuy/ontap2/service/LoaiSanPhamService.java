package thigk2.nguyenphuctamhuy.ontap2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.nguyenphuctamhuy.ontap2.models.LoaiSanPham;
import thigk2.nguyenphuctamhuy.ontap2.repos.LoaiSanPhamRepos;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSanPhamService {
    
    @Autowired
    private LoaiSanPhamRepos loaiSanPhamRepos;
    

    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamRepos.findAll();
    }

    public LoaiSanPham getLoaiSanPham(int id) {
        return loaiSanPhamRepos.findById(id).orElse(null);
    }

    public void saveLoaiSanPham(LoaiSanPham loai) {
        loaiSanPhamRepos.save(loai);
    }
    
    public void deleteLoaiSanPham(int id) {
        if (loaiSanPhamRepos.existsById(id)) {
            loaiSanPhamRepos.deleteById(id);
        }
    }
}