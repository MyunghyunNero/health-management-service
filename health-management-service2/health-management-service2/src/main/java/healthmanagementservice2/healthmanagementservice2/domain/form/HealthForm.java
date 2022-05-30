package healthmanagementservice2.healthmanagementservice2.domain.form;

import healthmanagementservice2.healthmanagementservice2.domain.Location;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class HealthForm {

    private Long id;

    private Location exerciseLocation;

    @NotBlank(message = "운동 날짜를 입력하세요.")
    private String exercisetime;

    @NotBlank(message = "운동 이름을 입력하세요.")
    private String exerciseName;
    private int healthset;

    private int healthcount;

    private String exercisestate;
}
