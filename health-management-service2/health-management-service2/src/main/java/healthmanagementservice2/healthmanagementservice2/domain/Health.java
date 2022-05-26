package healthmanagementservice2.healthmanagementservice2.domain;


import jdk.dynalink.beans.StaticClass;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "healths")
@Getter @Setter
@Entity
public class Health{

    @Id @GeneratedValue
    @Column(name = "health_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; //헬스 회원

    @Enumerated(EnumType.STRING)
    private Location exerciseLocation;
    private String exercisetime;
    private String exerciseName;
    private int healthset;
    private int healthcount;

    public static Health createHealth(Member member, Health health){
        health.setMember(member);
        return health;
    }
}
