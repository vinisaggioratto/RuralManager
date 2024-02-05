package com.vgs.rm.service;

import com.vgs.rm.dto.BuildingDTO;
import com.vgs.rm.entity.Building;
import com.vgs.rm.repository.BuildingRepository;
import com.vgs.rm.viewdto.BuildingViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<BuildingViewDTO> getAll() {
        return repository.findAll().stream().map(
                building -> new BuildingViewDTO(
                        building.getId(), building.getName(), building.getDescription(),
                        building.getActive(), building.getTypeBuilding().name()
                )
        ).collect(Collectors.toList());
    }

    public BuildingViewDTO getFindById(Long id) {
        Optional<Building> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Building not found.");
        }
        Building building = optional.get();
        return new BuildingViewDTO(
                building.getId(), building.getName(), building.getDescription(),
                building.getActive(), building.getTypeBuilding().name()
        );
    }
    @Transactional
    public BuildingViewDTO save(BuildingDTO building) {
        Building buiSave = mapper.map(building, Building.class);
        repository.save(buiSave);
        return new BuildingViewDTO(
                building.getId(), building.getName(), building.getDescription(),
                building.getActive(), building.getTypeBuilding().name()
        );
    }
    @Transactional
    public BuildingViewDTO update(BuildingDTO building){
        Building buiSave = mapper.map(building, Building.class);
        Optional<Building> optional = repository.findById(building.getId());
        if (!optional.isPresent()){
            throw new RuntimeException("Building not found.");
        }
        repository.save(buiSave);
        return new BuildingViewDTO(
                building.getId(), building.getName(), building.getDescription(),
                building.getActive(), building.getTypeBuilding().name()
        );
    }
    @Transactional
    public void delete(Long id){
        Optional<Building> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Building not found.");
        }
        Building building = optional.get();
        building.setActive(false);
        repository.save(building);
    }

}
