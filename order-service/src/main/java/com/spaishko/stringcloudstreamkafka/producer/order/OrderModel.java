package com.spaishko.stringcloudstreamkafka.producer.order;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString(callSuper = true)
@Getter
@Setter
public class OrderModel extends OrderBaseModel<OrderModel.OrderLineModel> {

    private UUID uuid;

    @ToString(callSuper = true)
    @Getter
    @Setter
    public static class OrderLineModel extends OrderLineBaseModel {

        private UUID uuid;
        private OrderLineStatus orderLineStatus;

    }
}
