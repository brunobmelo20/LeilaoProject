package auction.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Item {
    private String id;
    private String itemName;
    private Date itemEnding;
    private Double highestBid = 0.0;

    public String getId() { return id; }
    public void setId(String id) {this.id = id;}

    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public Date getItemEnding(){
        return itemEnding;
    }
    public void setItemEnding(Date itemEnding){
        this.itemEnding = itemEnding;
    }

    public Double getHighestBid() {return highestBid;}
    public void setHighestBid(Double highestBid) {this.highestBid = highestBid;}



}
