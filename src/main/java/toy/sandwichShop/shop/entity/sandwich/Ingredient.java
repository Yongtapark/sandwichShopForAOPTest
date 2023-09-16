package toy.sandwichShop.shop.entity.sandwich;

public interface Ingredient {
    String getName();
    Long getPrice();
    Long getStock();
    void addStock(Long quantity);
    void deductStock();
}
