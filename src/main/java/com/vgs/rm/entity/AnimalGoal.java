package com.vgs.rm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_goal")
@EqualsAndHashCode(of = "id")
public class AnimalGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objective;
    private String notes;
    private Boolean active;

    public AnimalGoal(Long id){
        this.id = id;
    }
}
