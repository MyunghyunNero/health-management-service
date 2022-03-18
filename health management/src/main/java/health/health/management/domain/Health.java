package health.health.management.domain;

import health.health.management.domain.type.Location;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Health {
    private Long num;
    private Location location;
    private String datetime;
    private String exerciseName;
    private int set;
    private int count;
    private String state="X";

    public Health(){}
    public Health(String datetime,String exerciseName, int set, int count) {
        this.datetime=datetime;
        this.exerciseName = exerciseName;
        this.set = set;
        this.count = count;
    }
}
