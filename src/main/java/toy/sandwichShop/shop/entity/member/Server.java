package toy.sandwichShop.shop.entity.member;

import org.springframework.stereotype.Component;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;

import java.util.ArrayList;
import java.util.List;
@Component
public class Server {
    private List<Sandwich> orderedSandwiches = new ArrayList<>();

    public List<Sandwich> transferSandwiches(List<Sandwich> sandwiches){
        this.orderedSandwiches = sandwiches;
        return orderedSandwiches;
    }

    public void completeOrder(){
        this.orderedSandwiches.clear();
    }
}
