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

    public Sandwich createSandwich(Ingredient ingredient) {
        ingredient.deductStock();
      return new Sandwich(ingredient);
    }

    public Sandwich addIngredientToSandwich(MainIngredient mainIngredient, Sandwich sandwich) {
        sandwich.addIngredient(mainIngredient);
        return sandwich;
    }

    public Sandwich addSauceToSandwich(Sauce sauce, Sandwich sandwich) {
        sandwich.addSauce(sauce);
        return sandwich;
    }
}
