package com.vgs.rm.dto;

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
public class ActivityDTO {

    private Long id;
    private String name;
    private String description;
    private Timestamp initialDate;
    private Timestamp finalDate;
    private Boolean active;
    private Operation operation;
    private MainAccount mainAccount;
    private Building building;
}
