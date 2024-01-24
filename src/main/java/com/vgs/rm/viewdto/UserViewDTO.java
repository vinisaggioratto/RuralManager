package com.vgs.rm.viewdto;

import com.vgs.rm.entity.Register;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

    private Long id;
    private String name;
    private String login;
    private Boolean active;
    private String register;

    public UserViewDTO(Long id, String name, String login, Boolean active, Register register){
        this.id = id;
        this.name = name;
        this.login = login;
        this.active = active;
        this.register = register.getName();
    }
}
