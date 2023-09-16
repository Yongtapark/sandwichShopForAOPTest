package toy.sandwichShop.shop.entity.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import toy.sandwichShop.shop.entity.sandwich.Bread;
import toy.sandwichShop.shop.entity.sandwich.MainIngredient;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;
import toy.sandwichShop.shop.entity.sandwich.Sauce;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@Component
@NoArgsConstructor
public class SandwichMaker {

    private List<Sandwich> orderedSandwiches = new ArrayList<>();

    public Sandwich makeSandwich(Bread bread, MainIngredient mainIngredient, Sauce sauce) {
        Sandwich sandwich = new Sandwich(bread);
        sandwich.addMainIngredient(mainIngredient);
        sandwich.addSauce(sauce);
        return sandwich;
    }

    public List<Sandwich> prepareOrderedSandwiches(Sandwich sandwich){
        List<Sandwich> haveToMakeSandwiches = this.orderedSandwiches;
        haveToMakeSandwiches.add(sandwich);
        return orderedSandwiches;
    }

    public void completeOrder() {
        this.orderedSandwiches.clear();
    }

   public Long totalPrice(){
       Long totalPrice = 0L;
       List<Sandwich> orderedSandwichesList = this.orderedSandwiches;
       for (Sandwich sandwich : orderedSandwichesList) {
           totalPrice += sandwich.getPrice();
       }
       return totalPrice;
   }

}
