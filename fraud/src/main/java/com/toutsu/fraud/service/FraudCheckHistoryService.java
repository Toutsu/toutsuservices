package com.toutsu.fraud.service;

import com.toutsu.fraud.entity.FraudCheckHistory;
import com.toutsu.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository repository) {

    public boolean isFraudulentCustomer(Long customerId) {
        repository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
