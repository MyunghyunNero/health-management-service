package healthmanagementservice2.healthmanagementservice2.service;

import healthmanagementservice2.healthmanagementservice2.domain.Health;
import healthmanagementservice2.healthmanagementservice2.domain.Location;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.repository.HealthRepository;
import healthmanagementservice2.healthmanagementservice2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HealthService {
    private final HealthRepository healthRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void sign(Long memberId, Health health1){
        //멤버 조회
        Member member= memberRepository.findOne(memberId);
        //헬스 생성
        Health health=Health.createHealth(member,health1);
        healthRepository.save(health);
    }
    public List<Health> findAll(Long id){
        return healthRepository.findAll(id);
    }
    public List<Health> findByLocation(String location,Long id){
        return healthRepository.findByLocation(location, id);
    }
    public void delete(Long id){
        healthRepository.delete(id);
    }
}
