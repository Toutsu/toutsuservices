package com.toutsu.fraud.repository;

import com.toutsu.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Long> {
}