package pl.wszib.pizzamarket.web.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.pizzamarket.services.OrderService;
import pl.wszib.pizzamarket.services.PizzaService;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;
import pl.wszib.pizzamarket.web.models.PizzaModel;

@Controller
public class OrderController {

    private final PizzaService pizzaService;
    private final OrderService orderService;

    public OrderController(PizzaService pizzaService, OrderService orderService) {
        this.pizzaService = pizzaService;
        this.orderService = orderService;
    }

    @GetMapping("/order/{pizza-id}")
    public String orderForm(@PathVariable("pizza-id") Long pizzaId, Model model){
        PizzaModel pizza = pizzaService.getById(pizzaId);

        model.addAttribute("orderAddress", new OrderAddressModel());
        model.addAttribute("pizza", pizza);

        return "orderPage";
    }

    @PostMapping("/order/{pizza-id}")
    public String order(@PathVariable("pizza-id") Long pizzaId,
                        @Valid @ModelAttribute("orderAddress") OrderAddressModel orderAddressModel,
                        BindingResult result, Model model){
        if(result.hasErrors()){
            PizzaModel pizza = pizzaService.getById(pizzaId);
            model.addAttribute("pizza", pizza);

            return "orderPage";
        }

        final var orderId = orderService.saveOrder(pizzaId, orderAddressModel);
        model.addAttribute("orderId", orderId);

        return "orderConfirmationPage";
    }
}
