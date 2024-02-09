package com.vgs.rm.service;

import com.vgs.rm.dto.RaceAnimalDTO;
import com.vgs.rm.entity.RaceAnimal;
import com.vgs.rm.repository.RaceAnimalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class RaceAnimalService {

    @Autowired
    private RaceAnimalRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<RaceAnimalDTO> getAll() {
        return repository.findAll().stream().map(
                raceAnimal -> new RaceAnimalDTO(
                        raceAnimal.getId(), raceAnimal.getRace(), raceAnimal.getNotes(),
                        raceAnimal.getActive()
                )
        ).collect(Collectors.toList());
    }

    public RaceAnimalDTO getFindById(Long id) {
        Optional<RaceAnimal> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Race not found.");
        }

        RaceAnimal raceAnimal = optional.get();
        return new RaceAnimalDTO(
                raceAnimal.getId(), raceAnimal.getRace(), raceAnimal.getNotes(),
                raceAnimal.getActive()
        );
    }

    @Transactional
    public RaceAnimalDTO save(RaceAnimalDTO raceAnimal) {
        RaceAnimal racSave = mapper.map(raceAnimal, RaceAnimal.class);
        repository.save(racSave);
        return new RaceAnimalDTO(
                raceAnimal.getId(), raceAnimal.getRace(), raceAnimal.getNotes(),
                raceAnimal.getActive()
        );
    }

    @Transactional
    public RaceAnimalDTO update(RaceAnimalDTO raceAnimal) {
        RaceAnimal racSave = mapper.map(raceAnimal, RaceAnimal.class);
        Optional<RaceAnimal> optional = repository.findById(raceAnimal.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Race not found.");
        }
        repository.save(racSave);
        return new RaceAnimalDTO(
                raceAnimal.getId(), raceAnimal.getRace(), raceAnimal.getNotes(),
                raceAnimal.getActive()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<RaceAnimal> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Race not found.");
        }
        RaceAnimal raceAnimal = optional.get();
        raceAnimal.setActive(false);
        repository.save(raceAnimal);
    }
}
