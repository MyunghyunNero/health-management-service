package health.health.management.domain;

import health.health.management.domain.data.Location;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class health {
    private Long num;
    private Location location;
    private String exerciseName;
    private int set;
    private int count;
    private String state="not finish";

    public health(String exerciseName, int set, int count) {
        this.exerciseName = exerciseName;
        this.set = set;
        this.count = count;
    }
}
