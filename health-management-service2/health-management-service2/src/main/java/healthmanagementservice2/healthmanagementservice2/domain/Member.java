package healthmanagementservice2.healthmanagementservice2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id  @GeneratedValue
    @Column(name = "member_id")
    private long id;

    private String loginId;

    private String name;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<Health> healths =new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
