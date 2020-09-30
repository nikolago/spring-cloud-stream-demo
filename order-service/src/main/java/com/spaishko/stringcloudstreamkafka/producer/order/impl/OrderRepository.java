package com.spaishko.stringcloudstreamkafka.producer.order.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

}
