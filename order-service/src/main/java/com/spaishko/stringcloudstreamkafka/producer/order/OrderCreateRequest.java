package com.spaishko.stringcloudstreamkafka.producer.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class OrderCreateRequest extends OrderBaseModel<OrderCreateRequest.OrderLineCreateRequest> {

    @ToString(callSuper = true)
    @Getter
    @Setter
    public static class OrderLineCreateRequest extends OrderLineBaseModel {

    }
}
