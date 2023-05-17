package pl.wszib.pizzamarket.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String pizzaName;
    private BigDecimal price;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn
    private OrderAddressEntity orderAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderAddressEntity getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddressEntity orderAddress) {
        this.orderAddress = orderAddress;
    }
}
