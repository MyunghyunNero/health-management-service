package healthmanagementservice2.healthmanagementservice2.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class Orderitem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count;

    public static Orderitem createOrderItem(Item item,int price,int count){
        Orderitem orderitem=new Orderitem();
        orderitem.setItem(item);
        orderitem.setOrderPrice(price);
        orderitem.setCount(count);

        item.removeStock(count);
        return orderitem;
    }
    public void cancel() {
        getItem().addStock(count);
    }
}
