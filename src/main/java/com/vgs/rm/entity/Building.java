package com.vgs.rm.entity;

import com.vgs.rm.enums.TypeBuilding;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "building")
@EqualsAndHashCode(of = "id")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Boolean active;
    private TypeBuilding typeBuilding;

    public Building (Long id){
        this.id = id;
    }

}
