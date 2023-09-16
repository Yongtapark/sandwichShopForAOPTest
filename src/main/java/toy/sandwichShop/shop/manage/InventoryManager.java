package toy.sandwichShop.shop.manage;

import org.springframework.stereotype.Component;
import toy.sandwichShop.shop.entity.sandwich.Bread;
import toy.sandwichShop.shop.entity.sandwich.Ingredient;
import toy.sandwichShop.shop.entity.sandwich.MainIngredient;
import toy.sandwichShop.shop.entity.sandwich.Sauce;

import java.util.HashMap;
import java.util.Map;
@Component
public class InventoryManager {

    private Map<MainIngredient, Long> ingredientStock = new HashMap<>();
    private Map<Sauce, Long> sauceStock = new HashMap<>();
    private Map<Bread, Long> breadStock = new HashMap<>();

    public boolean checkAndDeductStock(Ingredient ingredient) {
        if (ingredient instanceof Bread) {
            deductBreadStock((Bread) ingredient);
        } else if (ingredient instanceof MainIngredient) {
            deductMainIngredientStock((MainIngredient) ingredient);
        } else if (ingredient instanceof Sauce) {
            deductSauceStock((Sauce) ingredient);
        } else {
            return false;
        }
        return true;
    }

    public boolean addStock(Ingredient ingredient,Long quantity) {
        if (ingredient instanceof Bread) {
            addBreadStock((Bread) ingredient,quantity);
        } else if (ingredient instanceof MainIngredient) {
            addMainIngredientStock((MainIngredient) ingredient,quantity);
        } else if (ingredient instanceof Sauce) {
            addSauceStock((Sauce) ingredient,quantity);
        } else {
            return false;
        }
        return true;
    }

    public Long checkStock(Ingredient ingredient) {
        if (ingredient instanceof Bread) {
            return checkBreadStock((Bread) ingredient);
        } else if (ingredient instanceof MainIngredient) {
            return checkMainIngredientStock((MainIngredient) ingredient);
        } else if (ingredient instanceof Sauce) {
            return checkSauceStock((Sauce) ingredient);
        } else {
            return null;
        }
    }


    // 재료 재고 추가
    public void addMainIngredientStock(MainIngredient mainIngredient, long quantity) {
        ingredientStock.put(mainIngredient, ingredientStock.getOrDefault(mainIngredient, 0L) + quantity);
    }

    // 소스 재고 추가
    public void addSauceStock(Sauce sauce, long quantity) {
        sauceStock.put(sauce, sauceStock.getOrDefault(sauce, 0L) + quantity);
    }

    // 빵 재고 추가
    public void addBreadStock(Bread bread, long quantity) {
        breadStock.put(bread, breadStock.getOrDefault(bread, 0L) + quantity);
    }

    // 재료 재고 감소
    public void deductMainIngredientStock(MainIngredient mainIngredient) {
        if (ingredientStock.containsKey(mainIngredient) && ingredientStock.get(mainIngredient) > 0) {
            ingredientStock.put(mainIngredient, ingredientStock.get(mainIngredient) - 1L);
        } else {
           throw new RuntimeException("주재료 재고가 부족합니다");
        }
    }

    // 소스 재고 감소
    public void deductSauceStock(Sauce sauce) {
        if (sauceStock.containsKey(sauce) && sauceStock.get(sauce) > 0) {
            sauceStock.put(sauce, sauceStock.get(sauce) - 1L);
        } else {
            throw new RuntimeException("소스 재고가 부족합니다");
        }
    }

    // 빵 재고 감소
    public void deductBreadStock(Bread bread) {
        if (breadStock.containsKey(bread) && breadStock.get(bread) > 0) {
            breadStock.put(bread, breadStock.get(bread) - 1L);
        } else {
            throw new RuntimeException("빵 재고가 부족합니다");
        }
    }

    // 특정 재료의 재고 확인
    public Long checkMainIngredientStock(MainIngredient mainIngredient) {
        return ingredientStock.getOrDefault(mainIngredient, 0L);
    }

    // 특정 소스의 재고 확인
    public Long checkSauceStock(Sauce sauce) {
        return sauceStock.getOrDefault(sauce, 0L);
    }

    // 특정 빵의 재고 확인
    public Long checkBreadStock(Bread bread) {
        return breadStock.getOrDefault(bread, 0L);
    }
}
