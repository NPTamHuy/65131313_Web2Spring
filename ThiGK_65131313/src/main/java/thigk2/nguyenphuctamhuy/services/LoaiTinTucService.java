package thigk2.nguyenphuctamhuy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.nguyenphuctamhuy.models.LoaiTinTuc;
import thigk2.nguyenphuctamhuy.repos.LoaiTinTucRepository;
import java.util.List;

@Service
public class LoaiTinTucService {
    @Autowired
    private LoaiTinTucRepository loaiTinTucRepository;

    public List<LoaiTinTuc> getAllLoaiTinTuc() { 
        return loaiTinTucRepository.findAll(); 
    }
    
    public LoaiTinTuc getLoaiTinTucById(int id) { 
        return loaiTinTucRepository.findById(id).orElse(null); 
    }
    
    public void saveLoaiTinTuc(LoaiTinTuc loai) { 
        loaiTinTucRepository.save(loai); 
    }
    
    public void deleteLoaiTinTuc(int id) {
        if (loaiTinTucRepository.existsById(id)) loaiTinTucRepository.deleteById(id);
    }
}