package com.panti.asuhan.model;

import com.panti.asuhan.auditing.DateConfig;

import javax.persistence.*;

@Entity
@Table(name = "category_program")
public class CategoryProgram extends DateConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
