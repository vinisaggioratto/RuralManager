package com.vgs.rm.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalBreedDTO {

    private Long id;
    @NotBlank(message = "Informe uma raça válida.")
    private String race;

    @Column(nullable = true)
    private String notes;
    private Boolean active;
}
