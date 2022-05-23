package healthmanagementservice2.healthmanagementservice2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Orderitem> orderItems= new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void setMember(Member member){
        this.member=member;
        member.getOrders().add(this);
    }
    public void addOrderItem(Orderitem orderitem){
        orderItems.add(orderitem);
        orderitem.setOrder(this);
    }
    public static Order createOrder(Member member,Orderitem... orderitems){
        Order order=new Order();
        order.setMember(member);
        for(Orderitem orderitem: orderitems){
            order.addOrderItem(orderitem);
        }
        order.setOrderStatus(OrderStatus.ORDER);
        return order;
    }

}
