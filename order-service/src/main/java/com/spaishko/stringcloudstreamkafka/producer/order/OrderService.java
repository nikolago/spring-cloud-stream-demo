package com.spaishko.stringcloudstreamkafka.producer.order;

import java.util.UUID;

public interface OrderService {

    OrderModel addOrder(OrderCreateRequest createRequest);

    OrderModel updateOrderLineStatus(UUID orderId, UUID orderLineId, OrderLineStatus newStatus);

}
