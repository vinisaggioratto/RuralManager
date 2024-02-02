package com.vgs.rm.dto;

import com.vgs.rm.enums.TypeRegister;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private Long id;
    @NotBlank(message = "Informe um nome válido.")
    private String name;
    @NotBlank(message = "Informe um cpf/cnpj válido.")
    private String cpf_cnpj;

    private Timestamp date_birth;
    @Email(message = "Informe um email válido.")
    private String email;
    @NotBlank(message = "Informe um telefone celular válido.")
    private String cell_phone;
    private Boolean is_whattsapp;
    @NotBlank(message = "Informe um nome de rua válido.")
    private String road;
    @NotBlank(message = "Informe um bairro válido.")
    private String district;
    @NotBlank(message = "Informe um estado válido.")
    private String state;
    @NotBlank(message = "Informe um país válido.")
    private String country;
    private Boolean active;
    private String notes;
    private TypeRegister typeRegister;
}
