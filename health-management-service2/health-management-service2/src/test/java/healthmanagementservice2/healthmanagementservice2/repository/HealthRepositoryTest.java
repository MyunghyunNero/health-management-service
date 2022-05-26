package healthmanagementservice2.healthmanagementservice2.repository;

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
public class HealthRepositoryTest {

    @Autowired
    HealthRepository healthRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void save(){
        Member member =new Member();
        memberRepository.save(member);
        Health health=new Health();
        health.setExerciseLocation(Location.ARM);
        health.setHealthcount(1);
        health.setExercisetime("123");
        health.setHealthcount(2);
        health.setExerciseName("arm");
        healthRepository.save(health);
        Assertions.assertThat(healthRepository.findOne(1L)).isEqualTo(health);
        List<Health> healths=new ArrayList<>();
        healths.add(health);
        //Assertions.assertThat(healthRepository.findAll(member.getId())).isEqualTo(healths);


    }
}
