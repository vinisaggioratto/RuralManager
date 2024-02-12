package com.vgs.rm.viewdto;

import com.vgs.rm.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimalViewDTO {

    private Long id;
    private String animalType;
    private String animalBreed;
    private String animalGoal;
    private String color;
    private Timestamp dateOfBirth;
    private Timestamp registrationDate;
    private String lote;
    private String earringNumber;
    private String registrationNumber;
    private String mainAccount;
    private String notes;
    private Boolean active;

    public AnimalViewDTO(Long id, AnimalType animalType, AnimalBreed animalBreed, AnimalGoal animalGoal,
                         String color, Timestamp dateOfBirth, Timestamp registrationDate, Lote lote,
                         String earringNumber, String registrationNumber, MainAccount mainAccount,
                         String notes, Boolean active) {
        this.id = id;
        this.animalType = animalType.getType();
        this.animalBreed = animalBreed.getRace();
        this.animalGoal = animalGoal.getObjective();
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.lote = lote.getNumberOfControl();
        this.earringNumber = earringNumber;
        this.registrationNumber = registrationNumber;
        this.mainAccount = mainAccount.getFantasyName();
        this.notes = notes;
        this.active = active;
    }
}
