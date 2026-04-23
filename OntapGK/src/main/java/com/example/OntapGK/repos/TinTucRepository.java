package com.example.OntapGK.repos;

import com.example.OntapGK.models.tintuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinTucRepository extends JpaRepository<tintuc, Integer> {
    
}
