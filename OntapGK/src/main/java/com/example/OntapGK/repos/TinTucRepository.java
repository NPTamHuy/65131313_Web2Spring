package com.example.OntapGK.repos;

import com.example.OntapGK.models.tintuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TinTucRepository extends JpaRepository<tintuc, Integer> {
    List<tintuc> findByLoaiTinTucIdLoai(Integer idLoai);
}