package com.spaishko.stringcloudstreamkafka.consumer.shipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class ShipmentModel extends ShipmentBaseModel {

    private UUID uuid;

}
