package com.vgs.rm.service;

import com.vgs.rm.dto.UserDTO;
import com.vgs.rm.entity.User;
import com.vgs.rm.repository.UserRepository;
import com.vgs.rm.viewdto.UserViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public PasswordEncoder passwordEncoder(){
     return new BCryptPasswordEncoder();
    };

    private ModelMapper mapper = new ModelMapper();

    public List<UserViewDTO> getAll() {
        return repository.findAll().stream().map(
                user -> new UserViewDTO(
                        user.getId(), user.getName(), user.getUsername(), user.getActive(),
                        user.getRegister().getName(), user.getRoles()
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
                user.getId(), user.getName(), user.getUsername(), user.getActive(),
                user.getRegister().getName(), user.getRoles()
        );
    }

    @Transactional
    public UserViewDTO save(UserDTO user) {
        User existUser = repository.findUserByUsername(user.getUsername());
        if (existUser != null){
            throw new RuntimeException("User already exists!");
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User userSave = mapper.map(user, User.class);
        repository.save(userSave);
        return new UserViewDTO(
                user.getId(), user.getName(), user.getUsername(), user.getActive(),
                user.getRegister().getName(), user.getRoles()
        );
    }

    @Transactional
    public UserViewDTO update(UserDTO user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        User usSave = mapper.map(user, User.class);
        Optional<User> optional = repository.findById(user.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("User not found.");
        }
        repository.save(usSave);
        return new UserViewDTO(
                user.getId(), user.getName(), user.getUsername(), user.getActive(),
                user.getRegister().getName(), user.getRoles()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<User> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("User not found.");
        }
        User user = optional.get();
        user.setActive(false);
        repository.save(user);
    }
}
