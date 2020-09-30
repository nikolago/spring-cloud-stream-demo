package com.spaishko.stringcloudstreamkafka.consumer.message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    boolean existsByValue(String value);

}
