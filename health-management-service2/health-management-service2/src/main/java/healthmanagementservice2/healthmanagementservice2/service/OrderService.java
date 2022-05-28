package healthmanagementservice2.healthmanagementservice2.service;

import healthmanagementservice2.healthmanagementservice2.domain.Item;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.domain.Order;
import healthmanagementservice2.healthmanagementservice2.domain.Orderitem;
import healthmanagementservice2.healthmanagementservice2.repository.ItemRepository;
import healthmanagementservice2.healthmanagementservice2.repository.MemberRepository;
import healthmanagementservice2.healthmanagementservice2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId,Long itemId,int count){
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item=itemRepository.findOne(itemId);
        //주문상품 생성
        Orderitem orderitem = Orderitem.createOrderItem(item,item.getPrice(),count);
        //주문 생성
        Order order=Order.createOrder(member,orderitem);
        orderRepository.save(order);
        return order.getId();
    }
    public List<Order> findAll(Long id){
        return orderRepository.findAll(id);
    }
    @Transactional
    public void cancelOrder(Long orderId){
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소
        order.cancel();
    }

}
