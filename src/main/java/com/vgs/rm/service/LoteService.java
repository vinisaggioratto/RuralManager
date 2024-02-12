package com.vgs.rm.service;

import com.vgs.rm.dto.LoteDTO;
import com.vgs.rm.entity.Lote;
import com.vgs.rm.repository.LoteRepository;
import com.vgs.rm.viewdto.LoteViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoteService {

    @Autowired
    private LoteRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<LoteViewDTO> getAll() {
        return repository.findAll().stream().map(
                lote -> new LoteViewDTO(
                        lote.getId(), lote.getMainAccount(), lote.getRegister(), lote.getNumberOfControl(),
                        lote.getAnimalType(), lote.getDateRegister(), lote.getTotalNumberOfAnimals(),
                        lote.getAnimalGoal(), lote.getIs_internal(), lote.getIs_acquisition(),
                        lote.getActive(), lote.getNotes()
                )
        ).collect(Collectors.toList());
    }

    public LoteViewDTO getFindById(Long id) {
        Optional<Lote> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Lote not found.");
        }
        Lote lote = optional.get();
        return new LoteViewDTO(
                lote.getId(), lote.getMainAccount(), lote.getRegister(), lote.getNumberOfControl(),
                lote.getAnimalType(), lote.getDateRegister(), lote.getTotalNumberOfAnimals(),
                lote.getAnimalGoal(), lote.getIs_internal(), lote.getIs_acquisition(),
                lote.getActive(), lote.getNotes()
        );
    }

    @Transactional
    public LoteViewDTO save(LoteDTO lote) {
        Lote loteSave = mapper.map(lote, Lote.class);
        repository.save(loteSave);
        return new LoteViewDTO(
                lote.getId(), lote.getMainAccount(), lote.getRegister(), lote.getNumberOfControl(),
                lote.getAnimalType(), lote.getDateRegister(), lote.getTotalNumberOfAnimals(),
                lote.getAnimalGoal(), lote.getIs_internal(), lote.getIs_acquisition(),
                lote.getActive(), lote.getNotes()
        );
    }

    @Transactional
    public LoteViewDTO update(LoteDTO lote) {
        Lote loteSave = mapper.map(lote, Lote.class);
        Optional<Lote> optional = repository.findById(lote.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Lote not found.");
        }
        repository.save(loteSave);
        return new LoteViewDTO(
                lote.getId(), lote.getMainAccount(), lote.getRegister(), lote.getNumberOfControl(),
                lote.getAnimalType(), lote.getDateRegister(), lote.getTotalNumberOfAnimals(),
                lote.getAnimalGoal(), lote.getIs_internal(), lote.getIs_acquisition(),
                lote.getActive(), lote.getNotes()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<Lote> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Lote not found.");
        }
        Lote lote = optional.get();
        lote.setActive(false);
        repository.save(lote);
    }
}
