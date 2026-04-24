package thigk2.nguyenphuctamhuy.ontap2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.nguyenphuctamhuy.ontap2.models.SanPham;
import thigk2.nguyenphuctamhuy.ontap2.repos.SanPhamRepos;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepos sanPhamRepos;

    public List<SanPham> getAllSanPham() {
        return sanPhamRepos.findAll();
    }

    public SanPham getSanPham (int id) {
    	return sanPhamRepos.getReferenceById(id);
    }

    public void saveSanPham(SanPham sanpham) {
        sanPhamRepos.save(sanpham);
    }


    public void deleteSanPham(int id) {
        if (sanPhamRepos.existsById(id)) {
            sanPhamRepos.deleteById(id);
        }
    }
}
