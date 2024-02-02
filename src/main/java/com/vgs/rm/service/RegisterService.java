package com.vgs.rm.service;

import com.vgs.rm.dto.RegisterDTO;
import com.vgs.rm.entity.Register;
import com.vgs.rm.repository.RegisterRepository;
import com.vgs.rm.viewdto.RegisterViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<RegisterViewDTO> getAll() {
        return repository.findAll().stream().map(
                register -> new RegisterViewDTO(
                        register.getId(), register.getName(), register.getCpf_cnpj(),
                        register.getEmail(), register.getCell_phone(), register.getIs_whattsapp(),
                        register.getActive(), register.getTypeRegister()
                )
        ).collect(Collectors.toList());
    }

    public RegisterViewDTO getFindById(Long id) {
        Optional<Register> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Register not found.");
        }
        Register register = optional.get();
        return new RegisterViewDTO(
                register.getId(), register.getName(), register.getCpf_cnpj(),
                register.getEmail(), register.getCell_phone(), register.getIs_whattsapp(),
                register.getActive(), register.getTypeRegister()
        );
    }

    @Transactional
    public RegisterViewDTO save(RegisterDTO register) {
        Register regSave = mapper.map(register, Register.class);
        repository.save(regSave);
        return new RegisterViewDTO(
                register.getId(), register.getName(), register.getCpf_cnpj(),
                register.getEmail(), register.getCell_phone(), register.getIs_whattsapp(),
                register.getActive(), register.getTypeRegister()
        );
    }

    @Transactional
    public RegisterViewDTO update(RegisterDTO register) {
        Register regSave = mapper.map(register, Register.class);
        Optional<Register> optional = repository.findById(register.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Register not found.");
        }
        repository.save(regSave);
        return new RegisterViewDTO(
                register.getId(), register.getName(), register.getCpf_cnpj(),
                register.getEmail(), register.getCell_phone(), register.getIs_whattsapp(),
                register.getActive(), register.getTypeRegister()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<Register> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Register not found.");
        }
        Register register = optional.get();
        register.setActive(false);
        repository.save(register);
    }
}
