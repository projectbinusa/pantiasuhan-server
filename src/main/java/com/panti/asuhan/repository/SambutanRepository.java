package com.panti.asuhan.repository;

import com.panti.asuhan.model.Sambutan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SambutanRepository extends JpaRepository<Sambutan , Long> {
    @Query(value = "SELECT * FROM sambutan ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Sambutan> getAll(Pageable pageable);
}
