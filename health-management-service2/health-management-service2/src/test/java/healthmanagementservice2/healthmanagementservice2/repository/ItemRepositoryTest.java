package healthmanagementservice2.healthmanagementservice2.repository;

import healthmanagementservice2.healthmanagementservice2.domain.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void save() throws Exception{
        Item item=Item.createItem("test",100,50);
        itemRepository.save(item);
        Assertions.assertThat(itemRepository.findOne(1L)).isEqualTo(item);
    }

}
