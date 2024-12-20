package com.panti.asuhan.repository;

import com.panti.asuhan.model.MateriAjar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MateriAjarRepository extends JpaRepository<MateriAjar, Long> {
    @Query(value = "SELECT * FROM materi_ajar ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<MateriAjar> getAll(Pageable pageable);
}
