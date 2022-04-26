package com.toutsu.fraud.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fraud_check_history")
public class FraudCheckHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_check_history_seq")
    @SequenceGenerator(name = "fraud_check_history_seq", sequenceName = "fraud_check_history_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "is_fraudster")
    private Boolean isFraudster;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}