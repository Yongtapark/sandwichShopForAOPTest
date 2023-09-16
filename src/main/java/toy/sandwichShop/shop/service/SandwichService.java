package toy.sandwichShop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.sandwichShop.shop.annotation.CheckStock;
import toy.sandwichShop.shop.entity.sandwich.*;

@Service
@Slf4j
@RequiredArgsConstructor
@CheckStock
public class SandwichService {

    public void addStock(Ingredient ingredient,Long quantity){
        ingredient.addStock(quantity);
    }

    public Sandwich createSandwich(Bread bread) {
        bread.deductStock();
      return new Sandwich(bread);
    }

    public Sandwich addIngredientToSandwich(MainIngredient mainIngredient, Sandwich sandwich) {
        sandwich.deductStock(mainIngredient);
        sandwich.addMainIngredient(mainIngredient);
        return sandwich;
    }

    public Sandwich addSauceToSandwich(Sauce sauce, Sandwich sandwich) {
        sandwich.deductStock(sauce);
        sandwich.addSauce(sauce);
        return sandwich;
    }

}
