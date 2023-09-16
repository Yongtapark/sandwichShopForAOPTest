package toy.sandwichShop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.sandwichShop.shop.entity.member.SandwichMaker;
import toy.sandwichShop.shop.entity.sandwich.Bread;
import toy.sandwichShop.shop.entity.sandwich.MainIngredient;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;
import toy.sandwichShop.shop.entity.sandwich.Sauce;
import toy.sandwichShop.shop.service.SandwichService;

@SpringBootTest
@Slf4j
class SandwichShopApplicationTests {

	@Autowired
	SandwichService sandwichService;

	@Test
	void contextLoads() {
		Bread bread = new Bread("호밀",500L);
		Sauce catchup = new Sauce("캐첩",200L);
		MainIngredient ham = new MainIngredient("햄",3000L);

		Sandwich sandwich = new Sandwich(bread);
		sandwich.addSauce(catchup);
		sandwich.addIngredient(ham);

		log.info("sandwich={}",sandwich);

		SandwichMaker sandwichMaker = new SandwichMaker();
		sandwichMaker.makeSandwich(sandwich);
		log.info("sandwichMaker.getOrderedSandwiches()={}",sandwichMaker.getOrderedSandwiches());
	}

	@Test
	void sandwichService() {
		Bread bread = new Bread("호밀",500L);
		Sauce catchup = new Sauce("캐첩",200L);
		MainIngredient ham = new MainIngredient("햄",3000L);

		sandwichService.addStock(bread,2L);
		sandwichService.addStock(catchup,2L);
		sandwichService.addStock(ham,2L);

		Sandwich sandwich = sandwichService.createSandwich(bread);
		sandwichService.addIngredientToSandwich(ham,sandwich);
		sandwichService.addSauceToSandwich(catchup,sandwich);

		log.info("sandwich={}",sandwich);
	}

}
