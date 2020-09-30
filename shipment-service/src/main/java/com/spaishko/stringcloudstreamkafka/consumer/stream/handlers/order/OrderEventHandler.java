package com.spaishko.stringcloudstreamkafka.consumer.stream.handlers.order;

import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentCreateRequest;
import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.MANDATORY)
class OrderEventHandler {

    private final ShipmentService shipmentService;
    private final OrderEventHandlerMapper mapper;

    public void onOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("OrderCreatedEvent: " + event);
        ShipmentCreateRequest createRequest = mapper.map(event.getCreatedOrder());
        shipmentService.createShipment(createRequest);
    }

    public void onOrderLineStatusUpdated(OrderLineStatusUpdatedEvent event,
                                         UUID orderUuid,
                                         Instant eventTimestamp) {
        log.info("OrderLineStatusUpdatedEvent: " + event);
        log.info("orderUuid: " + orderUuid);
        log.info("eventTimestamp: " + eventTimestamp);
//        if (true) {
//            throw new RuntimeException();
//        }
    }

}
