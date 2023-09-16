package toy.sandwichShop.shop.entity.sandwich;

import java.util.ArrayList;
import java.util.List;
public class Sandwich {
    private Bread bread;
    private List<MainIngredient> mainIngredientList = new ArrayList<>();
    private List<Sauce> sauceList = new ArrayList<>();

    public Sandwich(Bread bread) {
        this.bread = bread;
    }

    public Sandwich addIngredient(MainIngredient mainIngredient) {
        this.mainIngredientList.add(mainIngredient);
        return this;
    }

    public Sandwich addSauce(Sauce sauce) {
        this.sauceList.add(sauce);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder name = new StringBuilder();
        name.append(bread.getName());

        for (MainIngredient mainIngredient : mainIngredientList) {
            name.append(" ").append(mainIngredient.getName());
        }

        for (Sauce sauce : sauceList) {
            name.append(" ").append(sauce.getName());
        }

        name.append(" 샌드위치");
        return name.toString();
    }

}
