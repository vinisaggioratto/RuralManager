package com.vgs.rm.viewdto;

import com.vgs.rm.entity.Activity;
import com.vgs.rm.entity.Register;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAccountViewDTO {

    private Long id;
    private String fantasyName;
    private String cpf_cnpj;
    private Integer numberAuthorizedUsers; //default 1
    private Integer numberAuthorizedActivity; //default 1
    private Boolean active;
    private String register;

    public MainAccountViewDTO(Long id, String fantasyName, String cpf_cnpj, Integer numberAuthorizedUsers,
                              Integer numberAuthorizedActivity, Boolean active, Register register) {
        this.id = id;
        this.fantasyName = fantasyName;
        this.cpf_cnpj = cpf_cnpj;
        this.numberAuthorizedUsers = numberAuthorizedUsers;
        this.numberAuthorizedActivity = numberAuthorizedActivity;
        this.active = active;
        this.register = register.getName();
    }
}
