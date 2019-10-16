package auction.domain;

public class Bid {
    private String id;
    private String nome;
    private Double value;
    private String itemId;
    private Enum choice;

//    public Bid(String id, String nome, Double value, String itemId, Enum choice) {
//        this.id = id;
//        this.nome = nome;
//        this.value = value;
//        this.itemId = itemId;
//        this.choice = Choice.WAITING;
//    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Double getValue() {return value;}
    public void setValue(Double value) {this.value = value;}

    public String getItemId() {return itemId;}
    public void setItemId(String itemId) {this.itemId = itemId;}

    public Enum getChoice() {return choice;}
    public void setChoice(Enum choice) {this.choice = choice;}



}
