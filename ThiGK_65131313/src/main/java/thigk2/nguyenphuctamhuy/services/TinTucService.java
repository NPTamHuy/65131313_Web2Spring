package thigk2.nguyenphuctamhuy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thigk2.nguyenphuctamhuy.models.TinTuc;
import thigk2.nguyenphuctamhuy.repos.TinTucRepository;
import java.util.List;

@Service
public class TinTucService {
    @Autowired
    private TinTucRepository tinTucRepository;

    public List<TinTuc> getAllTinTuc() { 
        return tinTucRepository.findAll(); 
    }

    public TinTuc getTinTucById(int id) { 
        return tinTucRepository.findById(id).orElse(null); 
    }

    public List<TinTuc> getTinTucByLoai(int idLoai) {
        return tinTucRepository.findByLoaiTinTuc_IdLoai(idLoai);
    }

    public void saveTinTuc(TinTuc tintuc) { 
        tinTucRepository.save(tintuc); 
    }

    public void deleteTinTuc(int id) {
        if (tinTucRepository.existsById(id)) tinTucRepository.deleteById(id);
    }
}