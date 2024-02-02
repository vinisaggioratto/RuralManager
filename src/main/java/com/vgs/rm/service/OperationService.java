package com.vgs.rm.service;

import com.vgs.rm.dto.OperationDTO;
import com.vgs.rm.entity.Operation;
import com.vgs.rm.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationService {

    @Autowired
    private OperationRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<OperationDTO> getAll() {
        return repository.findAll().stream().map(
                operation -> new OperationDTO(
                        operation.getId(), operation.getName(), operation.getDescription(),
                        operation.getActive()
                )
        ).collect(Collectors.toList());
    }

    public OperationDTO getFindById(Long id) {
        Optional<Operation> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Operation not found.");
        }

        Operation operation = optional.get();
        return new OperationDTO(
                operation.getId(), operation.getName(), operation.getDescription(),
                operation.getActive()
        );
    }

    public OperationDTO save(OperationDTO operation) {
        Operation opSave = mapper.map(operation, Operation.class);
        repository.save(opSave);
        return new OperationDTO(
                operation.getId(), operation.getName(), operation.getDescription(),
                operation.getActive()
        );
    }

    public OperationDTO update(OperationDTO operation) {
        Operation opSave = mapper.map(operation, Operation.class);
        Optional<Operation> optional = repository.findById(operation.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Operation not found.");
        }
        repository.save(opSave);
        return new OperationDTO(
                operation.getId(), operation.getName(), operation.getDescription(),
                operation.getActive()
        );
    }

    public void delete(Long id) {
        Optional<Operation> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Operation not found.");
        }
        Operation operation = optional.get();
        operation.setActive(false);
        repository.save(operation);
    }
}
