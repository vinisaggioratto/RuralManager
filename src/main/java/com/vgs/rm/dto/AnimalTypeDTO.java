package com.vgs.rm.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalTypeDTO {

    private Long id;
    @NotBlank(message = "Informe um tipo válido.")
    private String type;
    @Column(nullable = true)
    private String notes;
    private Boolean active;
}
