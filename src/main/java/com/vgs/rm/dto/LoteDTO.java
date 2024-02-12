package com.vgs.rm.dto;

import com.vgs.rm.entity.AnimalGoal;
import com.vgs.rm.entity.AnimalType;
import com.vgs.rm.entity.MainAccount;
import com.vgs.rm.entity.Register;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoteDTO {

    private Long id;
    private MainAccount mainAccount;
    private Register register;
    private String numberOfControl;
    private AnimalType animalType;
    private Timestamp dateRegister;
    private Integer totalNumberOfAnimals;
    private AnimalGoal animalGoal;
    private Boolean is_internal;
    private Boolean is_acquisition;
    private Boolean active;
    private String notes;
}
