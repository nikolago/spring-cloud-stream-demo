package com.spaishko.stringcloudstreamkafka.producer.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class OrderLineBaseModel {

    @NotEmpty
    private String item;
    @NotNull
    @Min(1)
    private Integer quantity;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal totalPrice;

}
