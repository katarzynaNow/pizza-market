package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wszib.pizzamarket.services.PizzaService;
import pl.wszib.pizzamarket.web.models.PizzaModel;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("resto-panel")
public class RestaurantController {

    private final PizzaService pizzaService;

    public RestaurantController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String restoPanelPage(Model model){
        model.addAttribute("pizzas",pizzaService.findAll());
        return "restoPanelPage";
    }
}
