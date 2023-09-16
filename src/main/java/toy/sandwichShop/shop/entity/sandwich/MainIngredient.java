package toy.sandwichShop.shop.entity.sandwich;

import lombok.Getter;
import toy.sandwichShop.shop.annotation.CheckStock;

@Getter
public class MainIngredient implements Ingredient {

    private String name;
    private Long price;
    private Long stock = 0L;

    public MainIngredient(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void addStock(Long quantity) {
        this.stock += quantity;
    }

    @Override
    public void deductStock() {
        if(this.stock <= 0){
            throw new RuntimeException(this.name + " 재고부족");
        }
        this.stock -= 1;
    }
}
