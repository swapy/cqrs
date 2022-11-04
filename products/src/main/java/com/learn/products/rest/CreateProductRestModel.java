package com.learn.products.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    private String title;
    private Integer quantity;
    private BigDecimal price;
}
