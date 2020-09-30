package com.spaishko.stringcloudstreamkafka.producer.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@ToString
@Getter
@Setter
public class OrderBaseModel
        <OL extends OrderLineBaseModel> {

    @NotNull
    private UUID customerUuid;
    @NotNull
    @PastOrPresent
    private OffsetDateTime orderDate;

    @Valid
    @NotEmpty
    private List<OL> lineItems;

}
