package healthmanagementservice2.healthmanagementservice2.repository;

import healthmanagementservice2.healthmanagementservice2.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @PersistenceContext
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void save() throws Exception{
        Member member=new Member();
        member.setLoginId("test");
        member.setPassword("test");
        memberRepository.save(member);
        Member member2=memberRepository.findOne(member.getId());
        Assertions.assertThat(member.getId()).isEqualTo(1L);
        Assertions.assertThat(member2).isEqualTo(member);

    }
}
