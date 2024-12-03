package com.panti.asuhan.repository;


import com.panti.asuhan.model.Ekstrakurikuler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EkstrakurikulerRepository extends JpaRepository<Ekstrakurikuler , Long> {
    @Query(value = "SELECT * FROM ekstrakurikuler ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<Ekstrakurikuler> getAll(Pageable pageable);
}
