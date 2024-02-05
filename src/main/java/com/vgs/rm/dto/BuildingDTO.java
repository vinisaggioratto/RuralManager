package com.vgs.rm.dto;

import com.vgs.rm.enums.TypeBuilding;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingDTO {

    private Long id;
    @NotBlank(message = "Informe um nome válido.")
    private String name;
    @NotBlank(message = "Informe uma descrição.")
    private String description;
    private Boolean active;
    private TypeBuilding typeBuilding;
}
