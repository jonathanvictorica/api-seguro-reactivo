package com.jmg.seguros.controller;

import com.jmg.seguros.model.Policy;
import com.jmg.seguros.service.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/policy")
@Log4j2
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public Mono<ResponseEntity<Long>> create(@RequestBody Policy policy) {
        return policyService.save(policy)
                .map(resp -> new ResponseEntity<>(resp.getId(), HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE));
    }

    @GetMapping("/search")
    public Flux<Policy> search() {
        return policyService.search();
    }
}
