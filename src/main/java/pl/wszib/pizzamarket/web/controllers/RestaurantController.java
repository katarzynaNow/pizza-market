package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        final var pizzas = pizzaService.findAll();
        model.addAttribute("pizzas", pizzas);
        return "restoPanelPage";
    }

    @GetMapping("pizza/create")
    public String createPizzaForm(Model model){
        model.addAttribute("pizza", new PizzaModel());
        return "pizzaPage";
    }

    @PostMapping("pizza/create")
    public String createPizza(@ModelAttribute("pizza") PizzaModel pizzaModel){
        pizzaService.createPizza(pizzaModel);
        return "redirect:/resto-panel";
    }

}
