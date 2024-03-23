package com.jmg.seguros.controller;

import com.jmg.seguros.model.Policy;
import com.jmg.seguros.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/policy")
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
