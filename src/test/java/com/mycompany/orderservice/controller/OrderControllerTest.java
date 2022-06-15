package com.mycompany.orderservice.controller;

import com.mycompany.orderservice.dto.OrderDTO;
import com.mycompany.orderservice.controller.OrderController;
import com.mycompany.orderservice.dto.OrderDTO;
import com.mycompany.orderservice.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;
    @Mock
    private OrderService orderService;

    @Test
    @DisplayName("scenario for placing order")
    void testPlaceOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(2L);
        orderDTO.setUserId(3L);
        Mockito.when(orderService.placeOrder(Mockito.any())).thenReturn(orderDTO);
        ResponseEntity<OrderDTO> responseEntity = orderController.placeOrder(orderDTO);
        assertEquals(2L, responseEntity.getBody().getId());
        assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());


    }

}