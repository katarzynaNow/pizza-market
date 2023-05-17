package pl.wszib.pizzamarket.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wszib.pizzamarket.data.repositories.OpinionRepository;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public OpinionService(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

}
