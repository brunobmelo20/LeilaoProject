package auction.service;

import auction.domain.Bid;
import auction.domain.Item;
import auction.repository.BidRepository;
import auction.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BidServiceTest {

    @Mock
    ItemRepository itemRepository;
    @Mock
    BidRepository bidRepository;

    @InjectMocks
    BidService underTest;

    @Test(expected = RuntimeException.class)
    public void WhenItemIdIsNull(){

        //Arrange
        String id = "123";
        String nome = "Bruno";
        Double value = 150.0;
        String itemId = null;

        Bid bid = new Bid();

        bid.setId(id);
        bid.setNome(nome);
        bid.setValue(value);

        //when(itemRepository.getByHighest(idItem)).thenReturn(item.getHighestBid());

        //Act
        Bid actual = underTest.addBid(bid);

        //Assert

    }
}
