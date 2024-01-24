package com.vgs.rm.viewdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterViewDTO {

    private String name;
    private String cpf_cnpj;
    private String email;
    private String cell_phone;
    private Boolean is_whattsapp;
    private Boolean active;
}
