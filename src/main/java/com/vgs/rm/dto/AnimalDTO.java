package com.vgs.rm.dto;

import com.vgs.rm.entity.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private Long id;
    private AnimalType animalType;
    private AnimalBreed animalBreed;
    private AnimalGoal animalGoal;
    private String color;
    private Timestamp dateOfBirth;
    private Timestamp registrationDate;
    private Lote lote;
    private String earringNumber;
    private String registrationNumber;
    private MainAccount mainAccount;
    private String notes;
    private Boolean active;
}
