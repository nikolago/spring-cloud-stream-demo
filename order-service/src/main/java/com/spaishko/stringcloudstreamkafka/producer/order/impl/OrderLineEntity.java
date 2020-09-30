package com.spaishko.stringcloudstreamkafka.producer.order.impl;

import com.spaishko.stringcloudstreamkafka.producer.order.OrderLineStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_line")
class OrderLineEntity {

    @Id
    @GeneratedValue
    @Column(name = "uuid")
    private UUID uuid;

    @NotEmpty
    @Column(name = "item")
    private String item;

    @NotNull
    @Min(1)
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_order")
    private OrderEntity order;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "order_line_status")
    private OrderLineStatus orderLineStatus;

}
