package healthmanagementservice2.healthmanagementservice2.repository;

import healthmanagementservice2.healthmanagementservice2.domain.Health;
import healthmanagementservice2.healthmanagementservice2.domain.Location;
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

    public List<Health> findAll(Long id){
        return em.createQuery("select h from Health h join h.member m where m.id =:id",Health.class)
                .setParameter("id",id)
                .getResultList();
    }

    public Health findOne(Long id){
        return em.find(Health.class,id);
    }
    public List<Health> findByLocation(Location location, Long id){
        return em.createQuery("select h from Health h join h.member m where h.exerciseLocation =:location and m.id=:id ",Health.class)
                .setParameter("location",location)
                .setParameter("id",id)
                .getResultList();
    }

    public void delete(Long id){
        Health health=em.find(Health.class,id);
        em.remove(health);
    }
}
