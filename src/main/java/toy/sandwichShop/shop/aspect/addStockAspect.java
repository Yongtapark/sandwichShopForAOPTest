package toy.sandwichShop.shop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import toy.sandwichShop.shop.annotation.AddStock;
import toy.sandwichShop.shop.entity.sandwich.Ingredient;
import toy.sandwichShop.shop.manage.InventoryManager;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class addStockAspect {
    private final InventoryManager inventoryManager;

    @Around("@annotation(addStock)")
    public Object addStock(ProceedingJoinPoint joinPoint, AddStock addStock) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if(args[0] instanceof Ingredient){
            Ingredient ingredient = (Ingredient) args[0];
            Long addQuantity = (Long) args[1];
            Long beforeStock = inventoryManager.checkStock(ingredient);
            log.info(ingredient.getName() + " 재고상황 = {}",beforeStock);
            inventoryManager.addStock(ingredient,addQuantity);
            Long nowStock = inventoryManager.checkStock(ingredient);
            log.info(ingredient.getName() + " 재고 증가 ={} 현 재고 ={}",addQuantity,nowStock);
        }
        return joinPoint.proceed();
    }
}
