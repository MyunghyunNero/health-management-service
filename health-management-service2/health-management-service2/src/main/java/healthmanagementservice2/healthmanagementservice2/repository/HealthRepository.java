package healthmanagementservice2.healthmanagementservice2.repository;

import healthmanagementservice2.healthmanagementservice2.domain.Health;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HealthRepository {
    private final EntityManager em;

    public void save(Health health){
        em.persist(health);
    }

    public List<Health> findAll(){
        return em.createQuery("select h from Health h",Health.class)
                .getResultList();
    }

    public Health findOne(Long id){
        return em.find(Health.class,id);
    }

    public void delete(Long id){
        Health health=em.find(Health.class,id);
        em.remove(health);
    }
}
