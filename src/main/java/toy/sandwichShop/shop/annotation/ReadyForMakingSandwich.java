package toy.sandwichShop.shop.annotation;

import toy.sandwichShop.shop.entity.sandwich.Ingredient;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadyForMakingSandwich {
}
