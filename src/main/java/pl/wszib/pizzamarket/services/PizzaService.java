package pl.wszib.pizzamarket.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.wszib.pizzamarket.web.mappers.PizzaMapper;
import pl.wszib.pizzamarket.web.models.PizzaModel;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    
    public List<PizzaModel> findAll(){
        final var entities = pizzaRepository.findAll();

        return entities.stream()
                .map(PizzaMapper::toModel)//map(e -> PizzaMapper.toModel(e) - replace with method reference
                .toList();
    }

    public PizzaModel getById(Long pizzaId) {
        final var entity = pizzaRepository.findById(pizzaId)
                .orElseThrow(EntityNotFoundException::new);
        return PizzaMapper.toModel(entity);
    }

    @Transactional
    public void createPizza(PizzaModel pizzaModel) {
        final var entity = PizzaMapper.toEntity(pizzaModel);
        pizzaRepository.save(entity);
    }

    @Transactional
    public void deleteById(Long pizzaId) {
        pizzaRepository.deleteById(pizzaId);
    }

    public void editPizza(Long pizzaId, PizzaModel pizzaModel) {
        final var entity = pizzaRepository.findById(pizzaId)
                .orElseThrow(EntityNotFoundException::new);

        entity.setName(pizzaModel.getName());
        entity.setPrice(pizzaModel.getPrice());
        entity.setIngredients(pizzaModel.getIngredients());

        pizzaRepository.save(entity);
    }
}
