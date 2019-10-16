package auction.service;

import auction.domain.Item;
import auction.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;

    @Test
    public void WhenAddItemShouldSaveItem(){

        // Arrange
        String id = "1";
        String name = "banheira";

        Item item = new Item();

        item.setId(id);
        item.setItemName(name);

        when(itemRepository.save(item)).thenReturn(item);

        // Act
        Item actual = itemService.addItem(item);

        // Assert
        assertNotNull(item.getItemEnding());
        assertEquals(item, actual);
    }
}
