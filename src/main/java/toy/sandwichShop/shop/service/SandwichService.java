package toy.sandwichShop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.sandwichShop.shop.annotation.AddStock;
import toy.sandwichShop.shop.annotation.ReadyForMakingSandwich;
import toy.sandwichShop.shop.entity.sandwich.*;
import toy.sandwichShop.shop.manage.InventoryManager;

@Service
@Slf4j
@RequiredArgsConstructor
public class SandwichService {

    public void addStock(Ingredient ingredient,Long quantity){
    }

    public Sandwich createSandwich(Bread bread) {
      return new Sandwich(bread);
    }
    public Sandwich addIngredientToSandwich(Sandwich sandwich, MainIngredient mainIngredient) {
        sandwich.addIngredient(mainIngredient);
        return sandwich;
    }
    public Sandwich addSauceToSandwich(Sandwich sandwich, Sauce sauce) {
        sandwich.addSauce(sauce);
        return sandwich;
    }
}
