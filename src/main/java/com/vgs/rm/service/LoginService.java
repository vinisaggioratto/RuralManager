package com.vgs.rm.service;

import com.vgs.rm.dto.LoginDTO;
import com.vgs.rm.entity.User;
import com.vgs.rm.repository.LoginRepository;
import com.vgs.rm.security.SecurityConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    private ModelMapper mapper = new ModelMapper();

    public Boolean validarUser(LoginDTO login) { //, String password
        Boolean loginStatus = false;
        User user = loginRepository.findUserByLogin(login.getLogin());
        if (user != null && SecurityConfig.passwordEncoder().matches(login.getPassword(), user.getPassword())) {
            loginStatus = true;
            return loginStatus;
        } else {
            return loginStatus;
        }
    }
}
