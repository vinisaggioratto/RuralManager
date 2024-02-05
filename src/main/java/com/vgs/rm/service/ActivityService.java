package com.vgs.rm.service;

import com.vgs.rm.dto.ActivityDTO;
import com.vgs.rm.entity.Activity;
import com.vgs.rm.repository.ActivityRepository;
import com.vgs.rm.viewdto.ActivityViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<ActivityViewDTO> getAll() {
        return repository.findAll().stream().map(
                activity -> new ActivityViewDTO(
                        activity.getId(), activity.getName(), activity.getDescription(),
                        activity.getInitialDate(), activity.getFinalDate(), activity.getActive(),
                        activity.getOperation(), activity.getMainAccount(), activity.getBuilding()
                )
        ).collect(Collectors.toList());
    }

    public ActivityViewDTO getFindById(Long id) {
        Optional<Activity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Activity not found.");
        }

        Activity activity = optional.get();
        return new ActivityViewDTO(
                activity.getId(), activity.getName(), activity.getDescription(),
                activity.getInitialDate(), activity.getFinalDate(), activity.getActive(),
                activity.getOperation(), activity.getMainAccount(), activity.getBuilding()
        );
    }
    @Transactional
    public ActivityViewDTO save(ActivityDTO activity) {
        Activity actSave = mapper.map(activity, Activity.class);
        repository.save(actSave);
        return new ActivityViewDTO(
                activity.getId(), activity.getName(), activity.getDescription(),
                activity.getInitialDate(), activity.getFinalDate(), activity.getActive(),
                activity.getOperation(), activity.getMainAccount(), activity.getBuilding()
        );
    }
    @Transactional
    public ActivityViewDTO update(ActivityDTO activity) {
        Activity actSave = mapper.map(activity, Activity.class);
        Optional<Activity> optional = repository.findById(activity.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Activity not found.");
        }
        repository.save(actSave);
        return new ActivityViewDTO(
                activity.getId(), activity.getName(), activity.getDescription(),
                activity.getInitialDate(), activity.getFinalDate(), activity.getActive(),
                activity.getOperation(), activity.getMainAccount(), activity.getBuilding()
        );
    }
    @Transactional
    public void delete(Long id){
        Optional<Activity> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Activity not found.");
        }
        Activity activity = optional.get();
        activity.setActive(false);
        repository.save(activity);
    }
}
