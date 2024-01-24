package com.vgs.rm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 18, nullable = false, unique = true)
    private String cpf_cnpj;
    private Timestamp date_birth;
    @Email
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 14, nullable = false)
    private String cell_phone;
    private Boolean is_whattsapp;
    @Column(length = 100, nullable = false)
    private String road;
    @Column(length = 80, nullable = false)
    private String district;
    @Column(length = 30, nullable = false)
    private String state;
    @Column(length = 30, nullable = false)
    private String country;

    private Boolean active;
    @Column(length = 2000)
    private String notes;

    public Register(Long id) {
        this.id = id;
    }
}
