package com.vgs.rm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private Long id;
    private String name;
    private String cpf_cnpj;
    private Timestamp date_birth;
    private String email;
    private String cell_phone;
    private Boolean is_whattsapp;
    private String road;
    private String district;
    private String state;
    private String country;
    private Boolean active;
    private String notes;
}
