package toy.sandwichShop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.sandwichShop.shop.annotation.CheckStock;
import toy.sandwichShop.shop.entity.member.SandwichMaker;
import toy.sandwichShop.shop.entity.sandwich.Bread;
import toy.sandwichShop.shop.entity.sandwich.MainIngredient;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;
import toy.sandwichShop.shop.entity.sandwich.Sauce;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SandwichMakerService {
    private final SandwichMaker sandwichMaker;

    public Sandwich makeSandwich(Bread bread, MainIngredient mainIngredient, Sauce sauce){
        return sandwichMaker.makeSandwich(bread,mainIngredient,sauce);
    }

    public List<Sandwich> prepareOrderedSandwiches(Sandwich sandwich){
        return sandwichMaker.prepareOrderedSandwiches(sandwich);
    }

    public void completeOrder(){
        sandwichMaker.completeOrder();
    }
}
