package healthmanagementservice2.healthmanagementservice2.repository;

import healthmanagementservice2.healthmanagementservice2.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class,id);
    }
    public List<Order> findAll(long id){
        return em.createQuery("select o from Order o join o.member m where m.id =:id",Order.class)
                .setParameter("id",id)
                .getResultList();
    }
}
