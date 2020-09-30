package com.spaishko.stringcloudstreamkafka.producer.outboxevent;

import com.fasterxml.jackson.databind.JsonNode;
import com.spaishko.stringcloudstreamkafka.producer.domainevent.AggregateType;
import com.spaishko.stringcloudstreamkafka.producer.domainevent.EventType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@Getter
@Setter
public class OutboxEventModel {

    private UUID uuid;
    private AggregateType aggregateType;
    private UUID aggregateId;
    private EventType eventType;
    private LocalDateTime eventTimestamp;
    private JsonNode payload;

}
