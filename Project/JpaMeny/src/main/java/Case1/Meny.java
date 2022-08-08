package Case1;

public class Meny {
    private String name;
    private int price;
    @Weight
    private  int weight;
    @Discount
    private int discount;

    public Meny(String name, int price, int weight, int discount){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public Meny() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Meny{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", discount=" + discount +
                '}';
    }
}
