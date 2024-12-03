package com.panti.asuhan.repository;

import com.panti.asuhan.model.VisiMisi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisiMisiRepository extends JpaRepository<VisiMisi ,Long> {
    @Query(value = "SELECT * FROM visi_misi ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<VisiMisi> getAll(Pageable pageable);
}
