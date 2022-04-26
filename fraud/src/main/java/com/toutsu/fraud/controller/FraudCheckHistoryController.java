package com.toutsu.fraud.controller;

import com.toutsu.fraud.FraudCheckResponse;
import com.toutsu.fraud.service.FraudCheckHistoryService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/fraud")
@RestController
public record FraudCheckHistoryController(FraudCheckHistoryService service) {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        return new FraudCheckResponse(service.isFraudulentCustomer(customerId));
    }
}
