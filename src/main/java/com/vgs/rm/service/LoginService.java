package com.vgs.rm.service;

import com.vgs.rm.dto.LoginDTO;
import com.vgs.rm.entity.User;
import com.vgs.rm.repository.LoginRepository;
import com.vgs.rm.security.WebSecurityConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    private ModelMapper mapper = new ModelMapper();

    public Boolean validarUser(LoginDTO login) {
        Boolean loginStatus = false;
        User user = loginRepository.findUserByUsername(login.getUsername());
        if (user != null && WebSecurityConfig.passwordEncoder().matches(login.getPassword(), user.getPassword())) {
            loginStatus = true;
            return loginStatus;
        } else {
            return loginStatus;
        }
    }
}
