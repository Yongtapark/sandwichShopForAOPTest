package toy.sandwichShop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.sandwichShop.shop.entity.member.Server;
import toy.sandwichShop.shop.entity.sandwich.Sandwich;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServerService {

    private final Server server;

    public List<Sandwich> transferSandwiches(List<Sandwich> sandwiches){
        return server.transferSandwiches(sandwiches);
    }

    public void completeOrder(){
        server.completeOrder();
    }
}
