package com.vgs.rm.dto;

import com.vgs.rm.entity.Register;
import com.vgs.rm.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Informe um nome de registro válido.")
    private String name;
    @NotBlank(message = "Campo login é obrigatório.")
    private String username;
    @NotBlank(message = "Campo password é obrigatório.")
    private String password;
    private Boolean active;
    private Timestamp dateLastUpdate;
    private Register register;
    private List<Role> roles;
}
