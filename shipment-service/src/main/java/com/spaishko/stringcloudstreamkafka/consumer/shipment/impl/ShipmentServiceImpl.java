package com.spaishko.stringcloudstreamkafka.consumer.shipment.impl;

import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentCreateRequest;
import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentModel;
import com.spaishko.stringcloudstreamkafka.consumer.shipment.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RequiredArgsConstructor
@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repository;
    private final ShipmentServiceMapper mapper;

    @Transactional
    @Override
    public ShipmentModel createShipment(@Valid @NotNull ShipmentCreateRequest createRequest) {
        ShipmentEntity entity = mapper.map(createRequest);
        repository.save(entity);
        return mapper.map(entity);
    }
}
