package healthmanagementservice2.healthmanagementservice2.domain;


import jdk.dynalink.beans.StaticClass;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "healths")
@Getter @Setter
public class Health{

    @Id @GeneratedValue
    @Column(name = "health_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; //헬스 회원

    private String datatime;

    @Enumerated(EnumType.STRING)
    private Location location;
    private String datetime;
    private String exerciseName;
    private int set;
    private int count;
    private String state="X";

    public static Health createHealth(Member member, Health health){
        health.setMember(member);
        return health;
    }
}
