package com.panti.asuhan.repository;

import com.panti.asuhan.model.Sejarah;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SejarahRepository extends JpaRepository<Sejarah , Long> {
    @Query(value = "SELECT * FROM sejarah ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Sejarah> getAll(Pageable pageable);
}
