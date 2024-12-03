package com.panti.asuhan.repository;

import com.panti.asuhan.model.Keuangan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeuanganRepository extends JpaRepository<Keuangan , Long > {
    @Query(value = "SELECT * FROM keuangan  WHERE category = :category ", nativeQuery = true)
    Page<Keuangan> findByCategoryKeuangan_Id(String category, Pageable pageable);

    @Query(value = "SELECT * FROM keuangan ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Keuangan> getAll(Pageable pageable);
}
