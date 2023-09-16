package toy.sandwichShop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.sandwichShop.shop.entity.member.SandwichMaker;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopInteractionService {
    private final SandwichService sandwichService;
    private final SandwichMakerService sandwichMakerService;
    private final ServerService serverService;

    public List<Sandwich> transferToCustomer(List<Sandwich> sandwiches){
        return null;
    }
}
