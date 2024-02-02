package com.vgs.rm.dto;

import com.vgs.rm.entity.Register;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Informe um nome de registro válido.")
    private String name;
    @NotBlank(message = "Campo login é obrigatório.")
    private String login;
    @NotBlank(message = "Campo password é obrigatório.")
    private String password;
    private Boolean active;
    private Timestamp dateLastUpdate;
    private Register register;
}
