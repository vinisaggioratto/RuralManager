package com.vgs.rm.service;

import com.vgs.rm.dto.AnimalGoalDTO;
import com.vgs.rm.entity.AnimalGoal;
import com.vgs.rm.repository.AnimalGoalRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalGoalService {

    @Autowired
    private AnimalGoalRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<AnimalGoalDTO> getAll() {
        return repository.findAll().stream().map(
                animalGoal -> new AnimalGoalDTO(
                        animalGoal.getId(), animalGoal.getObjective(), animalGoal.getNotes(),
                        animalGoal.getActive()
                )
        ).collect(Collectors.toList());
    }

    public AnimalGoalDTO getFindById(Long id) {
        Optional<AnimalGoal> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Animal goal not found.");
        }

        AnimalGoal animalGoal = optional.get();
        return new AnimalGoalDTO(
                animalGoal.getId(), animalGoal.getObjective(), animalGoal.getNotes(),
                animalGoal.getActive()
        );
    }

    @Transactional
    public AnimalGoalDTO save(AnimalGoalDTO animalGoal) {
        AnimalGoal aniSave = mapper.map(animalGoal, AnimalGoal.class);
        repository.save(aniSave);
        return new AnimalGoalDTO(
                animalGoal.getId(), animalGoal.getObjective(), animalGoal.getNotes(),
                animalGoal.getActive()
        );
    }

    @Transactional
    public AnimalGoalDTO update(AnimalGoalDTO animalGoal) {
        AnimalGoal aniSave = mapper.map(animalGoal, AnimalGoal.class);
        Optional<AnimalGoal> optional = repository.findById(animalGoal.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Animal goal not found.");
        }
        repository.save(aniSave);
        return new AnimalGoalDTO(
                animalGoal.getId(), animalGoal.getObjective(), animalGoal.getNotes(),
                animalGoal.getActive()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<AnimalGoal> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Animal goal not found.");
        }
        AnimalGoal animalGoal = optional.get();
        animalGoal.setActive(false);
        repository.save(animalGoal);
    }
}
