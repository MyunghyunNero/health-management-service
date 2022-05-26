package healthmanagementservice2.healthmanagementservice2.service;

import healthmanagementservice2.healthmanagementservice2.domain.Health;
import healthmanagementservice2.healthmanagementservice2.domain.Location;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class HealthServiceTest {

    @Autowired
    HealthService healthService;

    @Autowired
    MemberService memberService;

    @Test
    public void findByLocation(){
        Member member =new Member();
        memberService.join(member);
        Health health=new Health();
        health.setExerciseLocation(Location.ARM);
        health.setHealthcount(1);
        health.setExercisetime("123");
        health.setHealthset(2);
        health.setExerciseName("arm");
        Health health1=new Health();
        health1.setExerciseLocation(Location.SHOULEDER);
        health1.setHealthcount(1);
        health1.setExercisetime("123");
        health1.setHealthset(2);
        health1.setExerciseName("arm");
        healthService.sign(member.getId(), health);
        healthService.sign(member.getId(),health1);
        List<Health> healths=new ArrayList<>();
        healths.add(health);
        //Assertions.assertThat(healthService.findAll(member.getId())).isEqualTo(healths);
        Assertions.assertThat(healthService.findByLocation(Location.ARM,member.getId())).isEqualTo(healths);
        Assertions.assertThat(healthService.findByLocation(Location.SHOULEDER,member.getId())).isEqualTo(null);

    }

}
