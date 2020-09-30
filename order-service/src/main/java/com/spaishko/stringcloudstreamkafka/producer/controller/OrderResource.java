package com.spaishko.stringcloudstreamkafka.producer.controller;

import com.spaishko.stringcloudstreamkafka.producer.order.OrderCreateRequest;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderLineStatus;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderModel;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService orderService;

    @PostMapping
    public OrderModel addOrder(
            @RequestBody @Valid OrderCreateRequest createOrderRequest) {
        return orderService.addOrder(createOrderRequest);
    }

    @PutMapping("/{orderId}/lines/{orderLineId}")
    public OrderModel updateOrderLine(
            @PathVariable("orderId") UUID orderId,
            @PathVariable("orderLineId") UUID orderLineId,
            @RequestBody @Valid OrderLineUpdateStatusRequest request) {
        return orderService.updateOrderLineStatus(orderId, orderLineId, request.getNewStatus());
    }


    @ToString
    @Getter
    @Setter
    private static class OrderLineUpdateStatusRequest {

        @NotNull
        private OrderLineStatus newStatus;

    }
}
