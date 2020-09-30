package com.spaishko.stringcloudstreamkafka.producer.outboxevent;


import com.spaishko.stringcloudstreamkafka.producer.domainevent.DomainEvent;

public interface OutboxEventService {

    OutboxEventModel persistEvent(DomainEvent<?> event);

}
