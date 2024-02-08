package com.vgs.rm.viewdto;

import com.vgs.rm.entity.Register;
import com.vgs.rm.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDTO {

    private Long id;
    private String name;
    private String username;
    private Boolean active;
    private String register;
    private List<Role> roles;

    public UserViewDTO(Long id, String name, String username, Boolean active, Register register,
                       List<Role> roles){
        this.id = id;
        this.name = name;
        this.username = username;
        this.active = active;
        this.register = register.getName();
        this.roles = roles;
    }
}
