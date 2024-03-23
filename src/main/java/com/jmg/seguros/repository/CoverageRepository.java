package com.jmg.seguros.repository;

import com.jmg.seguros.model.Coverage;
import com.jmg.seguros.model.Policy;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface CoverageRepository extends ReactiveCrudRepository<Coverage,Long> {
    Flux<Coverage> findByPolicyId(Long id);
}
