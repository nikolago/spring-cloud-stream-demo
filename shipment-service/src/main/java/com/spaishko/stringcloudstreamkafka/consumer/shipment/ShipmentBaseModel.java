package com.spaishko.stringcloudstreamkafka.consumer.shipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class ShipmentBaseModel {

    @NotNull
    private UUID customerUuid;
    @NotNull
    private UUID orderUuid;
    @NotNull
    private OffsetDateTime orderDate;

}
