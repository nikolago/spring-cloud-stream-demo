package com.spaishko.stringcloudstreamkafka.consumer.stream.handlers.order;

import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentCreateRequest;
import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentModel;
import com.spaishko.stringcloudstreamkafka.consumer.shipment.impl.ShipmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface OrderEventHandlerMapper {

    @Mapping(target = "orderUuid", source = "uuid")
    ShipmentCreateRequest map(OrderModel o);

}
