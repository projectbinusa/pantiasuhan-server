package com.panti.asuhan.repository;


import com.panti.asuhan.model.TenagaKependidikan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TenagaKependidikanRepository extends JpaRepository<TenagaKependidikan, Long> {
    @Query(value = "SELECT * FROM tenaga_kependidikan ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<TenagaKependidikan> getAll(Pageable pageable);
}
