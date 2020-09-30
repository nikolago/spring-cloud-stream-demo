package com.spaishko.stringcloudstreamkafka.consumer.shipment.impl;

import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentCreateRequest;
import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface ShipmentServiceMapper {

    ShipmentModel map(ShipmentEntity o);

    @Mapping(target = "uuid", ignore = true)
    ShipmentEntity map(ShipmentCreateRequest o);

}
