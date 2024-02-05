package com.vgs.rm.viewdto;

import com.vgs.rm.entity.Building;
import com.vgs.rm.entity.MainAccount;
import com.vgs.rm.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityViewDTO {

    private Long id;
    private String name;
    private String description;
    private Timestamp initialDate;
    private Timestamp finalDate;
    private Boolean active;
    private String operation;
    private String mainAccount;
    private String building;

    public ActivityViewDTO(Long id, String name, String description, Timestamp initialDate,
                           Timestamp finalDate, Boolean active, Operation operation, MainAccount mainAccount,
                           Building building) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.active = active;
        this.operation = operation.getName();
        this.mainAccount = mainAccount.getFantasyName();
        this.building = building.getName();
    }
}
