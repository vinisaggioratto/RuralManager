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
@Table(name = "race_animal")
@EqualsAndHashCode(of = "id")
public class AnimalBreed {  //raça animal

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String race;
    private String notes;
    private Boolean active;

    public AnimalBreed(Long id){
        this.id = id;
    }
}
