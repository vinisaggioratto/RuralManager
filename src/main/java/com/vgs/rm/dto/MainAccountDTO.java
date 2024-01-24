package com.vgs.rm.dto;

import com.vgs.rm.entity.Register;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAccountDTO {

    private Long id;
    private String fantasyName;
    private String cpf_cnpj;
    private Integer numberAuthorizedUsers; //default 1
    private Integer numberAuthorizedActivity; //default 1
    private Boolean active;
    private Register register;
}
