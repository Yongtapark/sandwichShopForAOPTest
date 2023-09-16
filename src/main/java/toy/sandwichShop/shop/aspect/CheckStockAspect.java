package toy.sandwichShop.shop.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import toy.sandwichShop.shop.annotation.CheckStock;
import toy.sandwichShop.shop.entity.sandwich.Ingredient;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class CheckStockAspect {

    @Around("@within(toy.sandwichShop.shop.annotation.CheckStock)")
    public Object stockCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result = null;

        log.info("signature ={}",joinPoint.getSignature());
        if(args[0] instanceof Ingredient ingredient){
            result = joinPoint.proceed();
            Long checkedStock = ingredient.getStock();
            log.info("{} 재고상황 = {}", ingredient.getName(), checkedStock);
        }
        return result;
    }
}

