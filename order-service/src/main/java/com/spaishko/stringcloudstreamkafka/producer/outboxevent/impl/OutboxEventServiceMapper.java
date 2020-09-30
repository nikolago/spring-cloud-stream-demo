package com.spaishko.stringcloudstreamkafka.producer.outboxevent.impl;

import com.spaishko.stringcloudstreamkafka.producer.outboxevent.OutboxEventModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface OutboxEventServiceMapper {

    OutboxEventModel map(OutboxEventEntity o);

}
