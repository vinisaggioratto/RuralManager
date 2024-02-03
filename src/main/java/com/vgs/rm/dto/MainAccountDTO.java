package com.vgs.rm.dto;

import com.vgs.rm.entity.Activity;
import com.vgs.rm.entity.Register;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainAccountDTO {

    private Long id;
    @NotBlank(message = "Informe um nome da conta princival válido.")
    private String fantasyName;
    @NotBlank(message = "Informe um cpf/cnpj válido.")
    private String cpf_cnpj;
    private Integer numberAuthorizedUsers; //default 1
    private Integer numberAuthorizedActivity; //default 1
    private Boolean active;
    private Register register;
}
