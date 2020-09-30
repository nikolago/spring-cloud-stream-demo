package com.spaishko.stringcloudstreamkafka.consumer.shipment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface ShipmentService {

    ShipmentModel createShipment(@Valid @NotNull ShipmentCreateRequest createRequest);

}
