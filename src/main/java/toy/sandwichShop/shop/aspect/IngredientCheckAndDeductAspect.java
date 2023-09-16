package toy.sandwichShop.shop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import toy.sandwichShop.shop.annotation.ReadyForMakingSandwich;
import toy.sandwichShop.shop.entity.sandwich.Ingredient;
import toy.sandwichShop.shop.manage.InventoryManager;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class IngredientCheckAndDeductAspect {
    private final InventoryManager inventoryManager;

    @Around("@annotation(readyForMakingSandwich)")
    public Object checkAndDeductStockBeforeAdding(ProceedingJoinPoint joinPoint, ReadyForMakingSandwich readyForMakingSandwich) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if(args[0] instanceof Ingredient){
            Ingredient ingredient = (Ingredient) args[0];
            if (!inventoryManager.checkAndDeductStock(ingredient)) {
                throw new RuntimeException(ingredient.getName() + " 재고가 부족합니다");
            }
            Long nowStock = inventoryManager.checkStock(ingredient);
            log.info(ingredient.getName() + " 재고 = {}",nowStock);
        }
        return joinPoint.proceed();
    }
}
