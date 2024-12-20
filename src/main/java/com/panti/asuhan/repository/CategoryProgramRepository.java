package com.panti.asuhan.repository;

import com.panti.asuhan.model.CategoryProgram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryProgramRepository extends JpaRepository<CategoryProgram , Long> {
    @Query(value = "SELECT * FROM category_program ORDER BY updated_date DESC" ,nativeQuery = true)
    Page<CategoryProgram> getAll(Pageable pageable);
}
