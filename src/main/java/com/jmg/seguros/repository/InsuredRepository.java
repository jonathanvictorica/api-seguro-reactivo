package com.jmg.seguros.repository;

import com.jmg.seguros.model.Insured;
import com.jmg.seguros.model.Policy;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface InsuredRepository extends ReactiveCrudRepository<Insured,Long> {
    Flux<Insured> findByPolicyId(Long id);
}
