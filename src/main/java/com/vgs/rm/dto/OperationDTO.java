package com.vgs.rm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {

    private Long id;
    @NotBlank(message = "Informe um nome válido.")
    private String name;
    @NotBlank(message = "Informe uma descrição válida.")
    private String description;

    private Boolean active;
}
