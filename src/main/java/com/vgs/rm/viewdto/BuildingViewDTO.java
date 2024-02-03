package com.vgs.rm.viewdto;

import com.vgs.rm.enums.TypeBuilding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingViewDTO {

    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private String typeBuilding;

    public BuildingViewDTO(Long id, String name, String description, Boolean active, TypeBuilding typeBuilding){
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.typeBuilding = typeBuilding.name();
    }
}
