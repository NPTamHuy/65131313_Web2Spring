package com.example.OntapGK.service;

import com.example.OntapGK.models.tintuc;
import com.example.OntapGK.repos.TinTucRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TinTucService {

    private final TinTucRepository tinTucRepository;

    public TinTucService(TinTucRepository tinTucRepository) {
        this.tinTucRepository = tinTucRepository;
    }

    public List<tintuc> getAllTinTuc() {
        return tinTucRepository.findAll();
    }

    public tintuc getTinTucById(Integer id) {
        Optional<tintuc> optional = tinTucRepository.findById(id);
        return optional.orElse(null);
    }

    public tintuc saveTinTuc(tintuc tin) {
        if (tin.getNgayDang() == null) {
            tin.setNgayDang(LocalDate.now());
        }
        return tinTucRepository.save(tin);
    }

    public void deleteTinTuc(Integer id) {
        tinTucRepository.deleteById(id);
    }
}