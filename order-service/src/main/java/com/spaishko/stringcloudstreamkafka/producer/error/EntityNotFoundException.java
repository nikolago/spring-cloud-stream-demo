package com.spaishko.stringcloudstreamkafka.producer.error;


public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
