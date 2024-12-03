package com.panti.asuhan.repository;

import com.panti.asuhan.model.KotakSaran;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KotakSaranRepository extends JpaRepository<KotakSaran ,Long> {
    @Query(value = "SELECT * FROM kotak_saran ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<KotakSaran> getAll(Pageable pageable);
}
