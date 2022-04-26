package com.toutsu.customer.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence")
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;
}
