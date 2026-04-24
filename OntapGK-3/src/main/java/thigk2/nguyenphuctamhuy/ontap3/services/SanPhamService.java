package thigk2.nguyenphuctamhuy.ontap3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.nguyenphuctamhuy.ontap3.models.SanPham;
import thigk2.nguyenphuctamhuy.ontap3.repos.SanPhamRepository;
import java.util.List;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAllSanPham() { return sanPhamRepository.findAll(); }
    public SanPham getSanPham (int id) { return sanPhamRepository.getReferenceById(id); }
    public void saveSanPham(SanPham sanpham) { sanPhamRepository.save(sanpham); }
    public void deleteSanPham(int id) {
        if (sanPhamRepository.existsById(id)) sanPhamRepository.deleteById(id);
    }
}