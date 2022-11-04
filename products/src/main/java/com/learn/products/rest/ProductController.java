package com.learn.products.rest;

import com.learn.products.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CommandGateway commandGateway;

    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel model) {
        CreateProductCommand command = CreateProductCommand.builder()
                .withProductId(UUID.randomUUID().toString())
                .withPrice(model.getPrice())
                .withQuantity(model.getQuantity())
                .withTitle(model.getTitle())
                .build();
        String val;
        try {
            val = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            val = e.getMessage();
        }
        return "product created" + model.getTitle();
    }

    @GetMapping
    public String getProduct() {
        return "product fetched";
    }

    @PutMapping
    public String updateProduct() {
        return "product updated";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "product deleted";
    }
}
