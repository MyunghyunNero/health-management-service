package healthmanagementservice2.healthmanagementservice2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public static Item createItem(String name,int price ,int stockQuantity){
        Item item=new Item();
        item.name=name;
        item.price=price;
        item.stockQuantity=stockQuantity;
        return item;
    }
    public void addStock(int quantity){
        this.stockQuantity+=quantity;
    }
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        this.stockQuantity=restStock;
    }

}
