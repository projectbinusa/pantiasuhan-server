package com.panti.asuhan.repository;

import com.panti.asuhan.model.Kontak;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KontakRespository extends JpaRepository<Kontak , Long> {
    @Query(value = "SELECT * FROM kontak ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Kontak> getAll(Pageable pageable);
}
