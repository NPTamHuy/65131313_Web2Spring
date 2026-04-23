package com.example.OntapGK.service;

import com.example.OntapGK.models.loaitintuc;
import com.example.OntapGK.repos.LoaiTinTucRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiTinTucService {

    private final LoaiTinTucRepository loaiTinTucRepository;

    public LoaiTinTucService(LoaiTinTucRepository loaiTinTucRepository) {
        this.loaiTinTucRepository = loaiTinTucRepository;
    }

    public List<loaitintuc> getAllLoaiTinTuc() {
        return loaiTinTucRepository.findAll();
    }

    public loaitintuc getLoaiTinTucById(Integer id) {
        Optional<loaitintuc> optional = loaiTinTucRepository.findById(id);
        return optional.orElse(null); 
    }

    public loaitintuc saveLoaiTinTuc(loaitintuc loaiTin) {
        return loaiTinTucRepository.save(loaiTin);
    }

    public void deleteLoaiTinTuc(Integer id) {
        loaiTinTucRepository.deleteById(id);
    }
    
}