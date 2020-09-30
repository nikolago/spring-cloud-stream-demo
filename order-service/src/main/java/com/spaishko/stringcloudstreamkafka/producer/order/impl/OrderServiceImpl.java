package com.spaishko.stringcloudstreamkafka.producer.order.impl;

import com.spaishko.stringcloudstreamkafka.producer.error.EntityNotFoundException;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderCreateRequest;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderLineStatus;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderModel;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderService;
import com.spaishko.stringcloudstreamkafka.producer.order.events.OrderCreated;
import com.spaishko.stringcloudstreamkafka.producer.order.events.OrderLineStatusUpdated;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderServiceMapper mapper;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    @Override
    public OrderModel addOrder(OrderCreateRequest createRequest) {
        OrderEntity entity = mapper.map(createRequest);

        repository.save(entity);
        OrderModel orderModel = mapper.map(entity);
        OrderCreated.OrderCreatedDetails eventDetails =
                OrderCreated.OrderCreatedDetails.builder()
                        .createdOrder(orderModel)
                        .build();
        eventPublisher.publishEvent(new OrderCreated(eventDetails, entity.getUuid()));

        return orderModel;
    }

    @Transactional
    @Override
    public OrderModel updateOrderLineStatus(UUID orderId, UUID orderLineId, OrderLineStatus newStatus) {

        OrderEntity order = repository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order with id " + orderId + " not found"));

        for (OrderLineEntity orderLine : order.getLineItems()) {
            if (orderLine.getUuid().equals(orderLineId)) {
                OrderLineStatus oldOrderLineStatus = orderLine.getOrderLineStatus();

                orderLine.setOrderLineStatus(newStatus);
                repository.save(order);

                OrderLineStatusUpdated.OrderUpdatedDetails eventDetails =
                        OrderLineStatusUpdated.OrderUpdatedDetails.builder()
                                .oldOrderLineStatus(oldOrderLineStatus)
                                .newOrderLineStatus(newStatus)
                                .build();
                eventPublisher.publishEvent(new OrderLineStatusUpdated(eventDetails, orderId));

                return mapper.map(order);
            }
        }

        throw new EntityNotFoundException("Order does not contain line with id " + orderLineId);
    }
}
