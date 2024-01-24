package com.vgs.rm.service;

import com.vgs.rm.dto.MainAccountDTO;
import com.vgs.rm.entity.MainAccount;
import com.vgs.rm.repository.MainAccountRepository;
import com.vgs.rm.viewdto.MainAccountViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MainAccountService {

    @Autowired
    private MainAccountRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<MainAccountViewDTO> getAll() {
        return repository.findAll().stream().map(
                main -> new MainAccountViewDTO(
                        main.getId(), main.getFantasyName(), main.getCpf_cnpj(), main.getNumberAuthorizedUsers(),
                        main.getNumberAuthorizedActivity(), main.getActive(), main.getRegister().getName()
                )
        ).collect(Collectors.toList());
    }

    public MainAccountViewDTO getFindById(Long id) {
        Optional<MainAccount> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Account not found.");
        }
        MainAccount main = optional.get();
        return new MainAccountViewDTO(
                main.getId(), main.getFantasyName(), main.getCpf_cnpj(), main.getNumberAuthorizedUsers(),
                main.getNumberAuthorizedActivity(), main.getActive(), main.getRegister().getName()
        );
    }

    @Transactional
    public MainAccountViewDTO save(MainAccountDTO main) {
        MainAccount maSave = mapper.map(main, MainAccount.class);
        repository.save(maSave);
        return new MainAccountViewDTO(
                main.getId(), main.getFantasyName(), main.getCpf_cnpj(), main.getNumberAuthorizedUsers(),
                main.getNumberAuthorizedActivity(), main.getActive(), main.getRegister().getName()
        );
    }

    @Transactional
    public MainAccountViewDTO update(MainAccountDTO main) {
        MainAccount maSave = mapper.map(main, MainAccount.class);
        Optional<MainAccount> optional = repository.findById(main.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Account not found.");
        }
        repository.save(maSave);
        return new MainAccountViewDTO(
                main.getId(), main.getFantasyName(), main.getCpf_cnpj(), main.getNumberAuthorizedUsers(),
                main.getNumberAuthorizedActivity(), main.getActive(), main.getRegister().getName()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<MainAccount> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Account not found.");
        }
        MainAccount mainAccount = optional.get();
        mainAccount.setActive(false);
        repository.save(mainAccount);
    }
}
