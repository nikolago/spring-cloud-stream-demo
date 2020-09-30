package com.spaishko.stringcloudstreamkafka.producer.order.adapters;

import com.spaishko.stringcloudstreamkafka.producer.order.events.OrderEvent;
import com.spaishko.stringcloudstreamkafka.producer.outboxevent.OutboxEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RequiredArgsConstructor
@Component
class OrderOutboxAdapter {

    private final OutboxEventService service;

    @EventListener(OrderEvent.class)
    @Transactional(propagation = Propagation.MANDATORY)
    @Validated
    public void createOutboxEvent(@Valid OrderEvent<?> event) {
        service.persistEvent(event);
    }

}
