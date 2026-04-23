package com.example.OntapGK.repos;

import com.example.OntapGK.models.loaitintuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTinTucRepository extends JpaRepository<loaitintuc, Integer> {
	
}