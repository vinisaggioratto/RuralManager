package com.vgs.rm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lote")
@EqualsAndHashCode(of = "id")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "main_account_id")
    private MainAccount mainAccount;

    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register;

    private String numberOfControl;

    @ManyToOne
    @JoinColumn(name = "animal_type_id")
    private AnimalType animalType;

    private Timestamp dateRegister;
    private Integer totalNumberOfAnimals;

    @ManyToOne
    @JoinColumn(name = "animal_goal_id")
    private AnimalGoal animalGoal;

    private Boolean is_internal;
    private Boolean is_acquisition;
    private Boolean active;
    private String notes;

    public Lote(Long id) {
        this.id = id;
    }

}
