package com.panti.asuhan.repository;

import com.panti.asuhan.model.Galeri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GaleriRepository extends JpaRepository<Galeri , Long> {
    @Query(value = "SELECT * FROM galeri ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Galeri> getAll(Pageable pageable);
}
