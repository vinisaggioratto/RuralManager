package com.vgs.rm.viewdto;

import com.vgs.rm.enums.TypeRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterViewDTO {

    private Long id;
    private String name;
    private String cpf_cnpj;
    private String email;
    private String cell_phone;
    private Boolean is_whattsapp;
    private Boolean active;
    private String typeRegister;

    public RegisterViewDTO(Long id, String name, String cpf_cnpj, String email, String cell_phone,
                           Boolean is_whattsapp, Boolean active, TypeRegister typeRegister) {
        this.id = id;
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.cell_phone = cell_phone;
        this.is_whattsapp = is_whattsapp;
        this.active = active;
        this.typeRegister = typeRegister.toString();
    }
}
