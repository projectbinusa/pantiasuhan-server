package com.panti.asuhan.repository;

import com.panti.asuhan.model.KondisiSekolah;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KondisiSekolahRepository extends JpaRepository<KondisiSekolah , Long> {
    @Query(value = "SELECT * FROM kondisi_sekolah ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<KondisiSekolah> getAll(Pageable pageable);
}
