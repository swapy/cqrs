package com.learn.products.core.events;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreatedEvent {

    private String productId;
    private String title;
    private Integer quantity;
    private BigDecimal price;
}
