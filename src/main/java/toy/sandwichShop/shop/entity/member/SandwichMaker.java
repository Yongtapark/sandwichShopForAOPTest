package toy.sandwichShop.shop.entity.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@NoArgsConstructor
public class SandwichMaker {

    private List<Sandwich> orderedSandwiches = new ArrayList<>();

   public List<Sandwich> makeSandwich(Sandwich sandwich){
       try {
           Thread.sleep(1000);
           this.orderedSandwiches.add(sandwich);
       } catch (InterruptedException e) {
           log.info("힘들어서 에러발생",e);
       }
       return orderedSandwiches;
   }

}
