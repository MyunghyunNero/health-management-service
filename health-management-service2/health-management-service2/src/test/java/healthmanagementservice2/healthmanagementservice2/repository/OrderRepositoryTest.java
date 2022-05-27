package healthmanagementservice2.healthmanagementservice2.repository;

import healthmanagementservice2.healthmanagementservice2.domain.Item;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.domain.Order;
import healthmanagementservice2.healthmanagementservice2.domain.Orderitem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    HealthRepository healthRepository;

    @Test
    public void save() throws Exception{
        Member member=new Member();
        member.setName("test");
        member.setLoginId("test1");
        member.setPassword("test1");
        memberRepository.save(member);
        Item item =Item.createItem("item1",100,10);
        itemRepository.save(item);
        Orderitem orderitem =Orderitem.createOrderItem(itemRepository.findOne(item.getId()), item.getPrice(), 5);
        Order order=Order.createOrder(member,orderitem);
        Order order1=Order.createOrder(member,orderitem);
        orderRepository.save(order);
        orderRepository.save(order1);
        Assertions.assertThat(itemRepository.findOne(item.getId())).isEqualTo(item);
        List<Order> orders =new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        //Assertions.assertThat(orderRepository.findAll(1l)).isEqualTo(null);
        //Assertions.assertThat(order).isEqualTo(orderRepository.findOne(3L));


    }
}
