package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.pizzamarket.data.entities.OpinionEntity;
import pl.wszib.pizzamarket.services.OpinionService;
import pl.wszib.pizzamarket.web.models.OpinionModel;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;
import pl.wszib.pizzamarket.web.models.PizzaModel;

import java.util.List;

@Controller
public class OpinionController {

    private final OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("/opinions")
    public String opinionsList(Model model){
        List<OpinionEntity> opinions = opinionService.findAll();
        model.addAttribute("opinions", opinions);

        OpinionModel opinionModel = new OpinionModel();
        model.addAttribute("opinionModel", opinionModel);

        return "opinionsPage";
    }

    @PostMapping("/opinions")
    public String addOpinion(OpinionModel opinionModel){
        opinionService.saveOpinion(opinionModel);
        return "redirect:/opinions";
    }

}
