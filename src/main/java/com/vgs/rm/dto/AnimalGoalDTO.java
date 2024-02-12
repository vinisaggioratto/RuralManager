package com.vgs.rm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalGoalDTO {
    private Long id;
    @NotBlank(message = "Informe um objetivo válido.")
    private String objective;
    private String notes;
    private Boolean active;
}
