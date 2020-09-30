package com.spaishko.stringcloudstreamkafka.producer.order.impl;

import com.spaishko.stringcloudstreamkafka.producer.order.OrderCreateRequest;
import com.spaishko.stringcloudstreamkafka.producer.order.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface OrderServiceMapper {

    OrderModel map(OrderEntity o);

    @Mapping(target = "uuid", ignore = true)
    OrderEntity map(OrderCreateRequest o);

    @Mapping(target = "order", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "orderLineStatus", constant = "ENTERED")
    OrderLineEntity map(OrderCreateRequest.OrderLineCreateRequest o);

}
