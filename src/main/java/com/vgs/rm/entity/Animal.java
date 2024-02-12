package com.vgs.rm.entity;

import com.vgs.rm.dto.AnimalGoalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_type_id")
    private AnimalType animalType;

    @ManyToOne
    @JoinColumn(name = "animal_breed_id")
    private AnimalBreed animalBreed;

    @ManyToOne
    @JoinColumn(name = "animal_goal_id")
    private AnimalGoal animalGoal;
    private String color;
    private Timestamp dateOfBirth;
    private Timestamp registrationDate;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
    private String earringNumber;
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "main_account_id")
    private MainAccount mainAccount;
    private String notes;
    private Boolean active;

    public Animal(Long id) {
        this.id = id;
    }

}
