package com.ru.klimash.producer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ru.klimash.producer.models.FoodOrder;
import com.ru.klimash.producer.services.FoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class FoodOrderController {

    private static final Logger log = LoggerFactory.getLogger(FoodOrderController.class);
    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping("/order/new_order")
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        log.info("Create food order request received");
        return foodOrderService.createFoodOrder(foodOrder);
    }
}
