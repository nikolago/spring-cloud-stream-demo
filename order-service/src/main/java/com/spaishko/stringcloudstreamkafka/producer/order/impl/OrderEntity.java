package com.spaishko.stringcloudstreamkafka.producer.order.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "purchase_order")
class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "uuid")
    private UUID uuid;

    @NotNull
    @Column(name = "customer_uuid")
    private UUID customerUuid;

    @NotNull
    @PastOrPresent
    @Column(name = "order_date")
    private OffsetDateTime orderDate;

    @Valid
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<OrderLineEntity> lineItems;

    public void setLineItems(List<OrderLineEntity> lineItems) {
        if (lineItems != null) {
            lineItems.forEach(item -> item.setOrder(this));
            this.lineItems = lineItems;
        }
    }
}
