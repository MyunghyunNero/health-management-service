package health.health.management.domain;

import health.health.management.domain.type.Location;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Health {
    @Id @GeneratedValue
    private Long num;
    @Enumerated(EnumType.STRING)
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
