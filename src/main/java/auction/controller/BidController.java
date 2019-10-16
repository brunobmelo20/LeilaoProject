package auction.controller;

import auction.domain.Bid;
import auction.domain.Item;
import auction.service.BidService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bids")
public class BidController {

    private final BidService service;

    public BidController(BidService service){
        this.service = service;
    }

    @PostMapping
    public Bid post(@RequestBody Bid bid) {
        return service.addBid(bid);
    }

    @PutMapping("/acceptItem/{bidId}")
    public Bid accept(@PathVariable String bidId){

        return  service.accept(bidId);
    }

    @GetMapping("BidsOfItem/{itemId}")
    public List<Bid> get(@PathVariable String itemId){

        return service.bidsOfItemList(itemId);
    }


}
