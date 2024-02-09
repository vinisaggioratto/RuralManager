package com.vgs.rm.service;

import com.vgs.rm.dto.AnimalBreedDTO;
import com.vgs.rm.entity.AnimalBreed;
import com.vgs.rm.repository.AnimalBreedRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class AnimalBreedService {

    @Autowired
    private AnimalBreedRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<AnimalBreedDTO> getAll() {
        return repository.findAll().stream().map(
                animalBreed -> new AnimalBreedDTO(
                        animalBreed.getId(), animalBreed.getRace(), animalBreed.getNotes(),
                        animalBreed.getActive()
                )
        ).collect(Collectors.toList());
    }

    public AnimalBreedDTO getFindById(Long id) {
        Optional<AnimalBreed> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Race not found.");
        }

        AnimalBreed animalBreed = optional.get();
        return new AnimalBreedDTO(
                animalBreed.getId(), animalBreed.getRace(), animalBreed.getNotes(),
                animalBreed.getActive()
        );
    }

    @Transactional
    public AnimalBreedDTO save(AnimalBreedDTO animalBreed) {
        AnimalBreed racSave = mapper.map(animalBreed, AnimalBreed.class);
        repository.save(racSave);
        return new AnimalBreedDTO(
                animalBreed.getId(), animalBreed.getRace(), animalBreed.getNotes(),
                animalBreed.getActive()
        );
    }

    @Transactional
    public AnimalBreedDTO update(AnimalBreedDTO animalBreed) {
        AnimalBreed racSave = mapper.map(animalBreed, AnimalBreed.class);
        Optional<AnimalBreed> optional = repository.findById(animalBreed.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Race not found.");
        }
        repository.save(racSave);
        return new AnimalBreedDTO(
                animalBreed.getId(), animalBreed.getRace(), animalBreed.getNotes(),
                animalBreed.getActive()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<AnimalBreed> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Race not found.");
        }
        AnimalBreed animalBreed = optional.get();
        animalBreed.setActive(false);
        repository.save(animalBreed);
    }
}
