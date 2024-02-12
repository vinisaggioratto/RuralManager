package com.vgs.rm.service;

import com.vgs.rm.dto.AnimalDTO;
import com.vgs.rm.entity.Animal;
import com.vgs.rm.repository.AnimalRepository;
import com.vgs.rm.viewdto.AnimalViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<AnimalViewDTO> getAll() {
        return repository.findAll().stream().map(
                animal -> new AnimalViewDTO(
                        animal.getId(), animal.getAnimalType(), animal.getAnimalBreed(),
                        animal.getAnimalGoal(), animal.getColor(), animal.getDateOfBirth(),
                        animal.getRegistrationDate(), animal.getLote(), animal.getEarringNumber(),
                        animal.getRegistrationNumber(), animal.getMainAccount(), animal.getNotes(),
                        animal.getActive()
                )
        ).collect(Collectors.toList());
    }

    public AnimalViewDTO getFindById(Long id) {
        Optional<Animal> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Animal not found.");
        }

        Animal animal = optional.get();
        return new AnimalViewDTO(
                animal.getId(), animal.getAnimalType(), animal.getAnimalBreed(),
                animal.getAnimalGoal(), animal.getColor(), animal.getDateOfBirth(),
                animal.getRegistrationDate(), animal.getLote(), animal.getEarringNumber(),
                animal.getRegistrationNumber(), animal.getMainAccount(), animal.getNotes(),
                animal.getActive()
        );
    }

    @Transactional
    public AnimalViewDTO save(AnimalDTO animal) {
        Animal aniSave = mapper.map(animal, Animal.class);
        repository.save(aniSave);
        return new AnimalViewDTO(
                animal.getId(), animal.getAnimalType(), animal.getAnimalBreed(),
                animal.getAnimalGoal(), animal.getColor(), animal.getDateOfBirth(),
                animal.getRegistrationDate(), animal.getLote(), animal.getEarringNumber(),
                animal.getRegistrationNumber(), animal.getMainAccount(), animal.getNotes(),
                animal.getActive()
        );
    }

    @Transactional
    public AnimalViewDTO update(AnimalDTO animal) {
        Animal aniSave = mapper.map(animal, Animal.class);
        Optional<Animal> optional = repository.findById(animal.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Animal not found.");
        }
        repository.save(aniSave);
        return new AnimalViewDTO(
                animal.getId(), animal.getAnimalType(), animal.getAnimalBreed(),
                animal.getAnimalGoal(), animal.getColor(), animal.getDateOfBirth(),
                animal.getRegistrationDate(), animal.getLote(), animal.getEarringNumber(),
                animal.getRegistrationNumber(), animal.getMainAccount(), animal.getNotes(),
                animal.getActive()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<Animal> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Animal not found.");
        }
        Animal animal = optional.get();
        animal.setActive(false);
        repository.save(animal);
    }
}
