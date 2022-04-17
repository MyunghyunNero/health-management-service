package health.health.management.service;

import health.health.management.domain.Health;
import health.health.management.domain.healthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HealthService {
    private final healthRepository healthRepository;

    public Long join(Health health){
        healthRepository.save(health);
        return health.getNum();
    }
    @Transactional         //변경 감지
    public void update(Long id,Health health) {
        Health findhealth = healthRepository.findById(id);
        findhealth.setDatetime(health.getDatetime());
        findhealth.setSet(health.getSet());
        findhealth.setCount(health.getCount());
    }

    public void changeState(Long num){
        Health findhealth = healthRepository.findById(num);
        findhealth.setState("O");
    }
    public void delete(Long num){
        healthRepository.delete(num);
    }
    public Health findById(Long num){
        return healthRepository.findById(num);
    }
    public List<Health> findByLocation(String location){
        return healthRepository.findByLocation(location);
    }
    public List<Health> findAll() {
        return healthRepository.findAll();
    }
}
