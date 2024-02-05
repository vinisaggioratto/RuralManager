package com.vgs.rm.service;

import com.vgs.rm.dto.UserDTO;
import com.vgs.rm.entity.User;
import com.vgs.rm.repository.UserRepository;
import com.vgs.rm.security.SecurityConfig;
import com.vgs.rm.viewdto.UserViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<UserViewDTO> getAll() {
        return repository.findAll().stream().map(
                user -> new UserViewDTO(
                        user.getId(), user.getName(), user.getLogin(), user.getActive(),
                        user.getRegister().getName()
                )
        ).collect(Collectors.toList());
    }

    public UserViewDTO getById(Long id) {
        Optional<User> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("User not found.");
        }
        User user = optional.get();
        return new UserViewDTO(
                user.getId(), user.getName(), user.getLogin(), user.getActive(),
                user.getRegister().getName()
        );
    }
    @Transactional
    public UserViewDTO save(UserDTO user){
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        User usSave = mapper.map(user, User.class);
        repository.save(usSave);
        return new UserViewDTO(
                user.getId(), user.getName(), user.getLogin(), user.getActive(),
                user.getRegister().getName()
        );
    }

    @Transactional
    public UserViewDTO update(UserDTO user){
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        User usSave = mapper.map(user, User.class);
        Optional<User> optional = repository.findById(user.getId());
        if (!optional.isPresent()){
            throw new RuntimeException("User not found.");
        }
        repository.save(usSave);
        return new UserViewDTO(
                user.getId(), user.getName(), user.getLogin(), user.getActive(),
                user.getRegister().getName()
        );
    }

    @Transactional
    public void delete(Long id){
        Optional<User> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("User not found.");
        }
        User user = optional.get();
        user.setActive(false);
        repository.save(user);
    }

    public Boolean validarUser(String login, String password){
        Boolean loginStatus = false;
        Boolean localizado = false;
        Optional<User> optional = repository.findByLogin(login);
        User usuario = optional.get();
        if(optional.isPresent()){
           loginStatus = SecurityConfig.passwordEncoder().matches(usuario.getPassword(), password);
        }
        return loginStatus;
    }


}
