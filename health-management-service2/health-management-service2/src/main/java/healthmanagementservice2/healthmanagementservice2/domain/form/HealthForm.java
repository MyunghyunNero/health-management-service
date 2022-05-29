package healthmanagementservice2.healthmanagementservice2.domain.form;

import healthmanagementservice2.healthmanagementservice2.domain.Location;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
public class HealthForm {
    private Long id;

    private Location exerciseLocation;

    @NotEmpty
    private String exercisetime;

    @NotEmpty
    private String exerciseName;
    private int healthset;

    private int healthcount;

    private String exercisestate;
}
