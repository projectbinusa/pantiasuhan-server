package com.panti.asuhan.repository;

import com.panti.asuhan.model.Prestasi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrestasiRepository extends JpaRepository<Prestasi , Long> {
    @Query(value = "SELECT * FROM prestasi ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Prestasi> getAll(Pageable pageable);

}
