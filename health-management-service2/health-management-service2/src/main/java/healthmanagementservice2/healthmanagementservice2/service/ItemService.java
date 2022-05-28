package healthmanagementservice2.healthmanagementservice2.service;

import healthmanagementservice2.healthmanagementservice2.domain.Item;
import healthmanagementservice2.healthmanagementservice2.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
    @Transactional         //변경 감지
    public void updateItem(Long id, String name, int price,int stockquantity) {
        Item item = itemRepository.findOne(id);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockquantity);
    }
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
