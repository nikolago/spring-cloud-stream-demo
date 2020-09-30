package com.spaishko.stringcloudstreamkafka.consumer.messagelog.impl;

import com.spaishko.stringcloudstreamkafka.consumer.messagelog.MessageLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
class MessageLogServiceImpl implements MessageLogService {

    private final MessageLogRepository repository;

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void processed(UUID eventId) {
        repository.save(new MessageLog(eventId, LocalDateTime.now()));
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public boolean alreadyProcessed(UUID eventId) {
        log.debug("Looking for event with id {} in message log", eventId);
        return repository.existsById(eventId);
    }
}
