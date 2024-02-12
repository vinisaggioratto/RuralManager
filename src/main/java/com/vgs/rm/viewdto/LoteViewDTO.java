package com.vgs.rm.viewdto;

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
public class LoteViewDTO {

    private Long id;
    private String mainAccount;
    private String register;
    private String numberOfControl;
    private String animalType;
    private Timestamp dateRegister;
    private Integer totalNumberOfAnimals;
    private String animalGoal;
    private Boolean is_internal;
    private Boolean is_acquisition;
    private Boolean active;
    private String notes;

    public LoteViewDTO(Long id, MainAccount mainAccount, Register register, String numberOfControl,
                       AnimalType animalType, Timestamp dateRegister, Integer totalNumberOfAnimals,
                       AnimalGoal animalGoal, Boolean is_internal, Boolean is_acquisition,
                       Boolean active, String notes) {
        this.id = id;
        this.mainAccount = mainAccount.getFantasyName();
        this.register = register.getName();
        this.numberOfControl = numberOfControl;
        this.animalType = animalType.getType();
        this.dateRegister = dateRegister;
        this.totalNumberOfAnimals = totalNumberOfAnimals;
        this.animalGoal = animalGoal.getObjective();
        this.is_internal = is_internal;
        this.is_acquisition = is_acquisition;
        this.active = active;
        this.notes = notes;
    }
}
