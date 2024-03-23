package com.jmg.seguros.repository;

import com.jmg.seguros.model.Policy;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PolicyRepository extends ReactiveCrudRepository<Policy,Long> {
    Flux<Policy> findAll(Sort sort);
}
