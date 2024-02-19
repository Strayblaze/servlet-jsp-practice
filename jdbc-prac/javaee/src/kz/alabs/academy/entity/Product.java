package kz.alabs.academy.entity;

import java.time.LocalDate;

public class Product {
    private Long id;
    private String name;
    private String description;
    private LocalDate expiration_date;

    public Product(Long id, String name, String description, LocalDate expiration_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expiration_date = expiration_date;
    }
    public Product(String name, String description, LocalDate expiration_date) {
        this.name = name;
        this.description = description;
        this.expiration_date = expiration_date;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }
}
