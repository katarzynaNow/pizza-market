package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.web.models.PizzaModel;

public class PizzaMapper {

    public static PizzaModel toModel (PizzaEntity entity){
        return new PizzaModel(
                entity.getId(),
                entity.getName(),
                entity.getIngredients(),
                entity.getPrice()

        );
    }

    public static PizzaEntity toEntity(PizzaModel model) {
        final var entity = new PizzaEntity();

        entity.setName(model.getName());
        entity.setPrice(model.getPrice());
        entity.setIngredients(model.getIngredients());

        return entity;
    }
}
