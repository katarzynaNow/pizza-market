package pl.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeliveryController {

    @GetMapping("delivery")
    public String deliveryPage(){
        return "deliveryPage";
    }
}
