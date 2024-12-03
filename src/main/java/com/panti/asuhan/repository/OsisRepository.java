package com.panti.asuhan.repository;

import com.panti.asuhan.model.Osis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OsisRepository extends JpaRepository<Osis, Long> {
    @Query(value = "SELECT * FROM osis ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Osis> getAll(Pageable pageable);
}
