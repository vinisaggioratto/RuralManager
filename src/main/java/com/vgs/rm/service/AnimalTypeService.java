package com.vgs.rm.service;

import com.vgs.rm.dto.AnimalTypeDTO;
import com.vgs.rm.entity.AnimalType;
import com.vgs.rm.repository.AnimalTypeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalTypeService {

    @Autowired
    private AnimalTypeRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<AnimalTypeDTO> getAll() {
        return repository.findAll().stream().map(
                animalType -> new AnimalTypeDTO(
                        animalType.getId(), animalType.getType(), animalType.getNotes(),
                        animalType.getActive()
                )
        ).collect(Collectors.toList());
    }

    public AnimalTypeDTO getFindById(Long id) {
        Optional<AnimalType> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Type not found.");
        }

        AnimalType animalType = optional.get();
        return new AnimalTypeDTO(
                animalType.getId(), animalType.getType(), animalType.getNotes(),
                animalType.getActive()
        );
    }

    @Transactional
    public AnimalTypeDTO save(AnimalTypeDTO animalType) {
        AnimalType aniSave = mapper.map(animalType, AnimalType.class);
        repository.save(aniSave);
        return new AnimalTypeDTO(
                animalType.getId(), animalType.getType(), animalType.getNotes(),
                animalType.getActive()
        );
    }

    @Transactional
    public AnimalTypeDTO update(AnimalTypeDTO animalType) {
        AnimalType aniSave = mapper.map(animalType, AnimalType.class);
        Optional<AnimalType> optional = repository.findById(animalType.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Type not found.");
        }
        repository.save(aniSave);
        return new AnimalTypeDTO(
                animalType.getId(), animalType.getType(), animalType.getNotes(),
                animalType.getActive()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<AnimalType> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Type not found.");
        }
        AnimalType animalType = optional.get();
        animalType.setActive(false);
        repository.save(animalType);
    }
}
