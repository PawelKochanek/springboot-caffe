package pl.bykowski.springbootcaffe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoffeeApi {
//    1. wstrzykiwanie do pola
//    @Autowired
//    private CoffeeRepo coffeeRepo;

    //    2. wstrzykiwanie do konstruktora
    private CoffeeRepo coffeeRepo;

    @Autowired
    public CoffeeApi(CoffeeRepo coffeeRepo) {
        this.coffeeRepo = coffeeRepo;
    }

    @GetMapping
    public Iterable<Coffee> getCoffes() {
        return coffeeRepo.findAll();
    }

    @PostMapping
    public void addCoffee(@RequestBody Coffee coffee) {
        coffeeRepo.save(coffee);
    }

    @DeleteMapping
    public void removeCoffe(@RequestParam Long id) {
        coffeeRepo.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Coffee coffee) {
        Optional<Coffee> foundElement = coffeeRepo.findById(coffee.getId());
        if(foundElement.isPresent())
        {
            coffeeRepo.save(coffee);
        }

//        Optional<Coffee> first = coffeList.stream()
//                .filter(element -> element.getId().equals(coffee.getId()))
//                .findFirst();
//        if (first.isPresent()) {
//            coffeList.set(coffeList.indexOf(first.get()), coffee);
//        }
        //////////////////// ALBO ///////////////////////////////////////////////
//        Coffee foundElement = null;
//        for (Coffee coffee1 : coffeList) {
//            if (coffee1.getId().equals(coffee.getId())) {
//                foundElement = coffee1;
//            }
//        }
//        coffeList.set(coffeList.indexOf(foundElement), coffee);
    }


//    @GetMapping("/hello/{lang}")
//    public String get(@PathVariable String lang) {
//        if (lang.equals("PL")) {
//            return "Cześć";
//        }
//        if (lang.equals("EN")) {
//            return "Hello";
//        }
//        return "Niepojemaju";
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void get() {
//        Coffee coffee1 = new Coffee("Prima", "Black");
//        Coffee coffee2 = new Coffee("Czibo", "Black");
//        Coffee coffee3 = new Coffee("Jacobs", "Black");
//        coffeeRepo.save(coffee1);
//        coffeeRepo.save(coffee2);
//        coffeeRepo.save(coffee3);
//    }
}
//    public String my() {
//        return "Moja zamiana";
//    }
//
//}
