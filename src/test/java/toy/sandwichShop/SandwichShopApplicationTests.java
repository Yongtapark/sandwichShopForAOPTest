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

		SandwichMaker sandwichMaker = new SandwichMaker();
		sandwichMaker.makeSandwich(bread,ham,catchup);

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

		SandwichMaker sandwichMaker = new SandwichMaker();
		Sandwich sandwich = sandwichMaker.makeSandwich(bread, ham, catchup);

		log.info("sandwich= {}, 가격= {}원",sandwich, sandwich.getPrice());
	}

}
