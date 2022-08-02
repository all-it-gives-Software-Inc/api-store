package com.example.storemicroservice.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String name;
    @NotEmpty
    private String address;
    @Column(unique = true)
    @NotEmpty
    private String cnpj;
    @NotEmpty
    private String site;
    @NotEmpty
    private String category;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
}
