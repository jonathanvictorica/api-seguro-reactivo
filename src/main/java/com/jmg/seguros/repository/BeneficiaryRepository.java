package com.jmg.seguros.repository;

import com.jmg.seguros.model.Beneficiary;
import com.jmg.seguros.model.Policy;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.Set;

@Repository
public interface BeneficiaryRepository extends ReactiveCrudRepository<Beneficiary,Long> {
   Flux<Beneficiary> findByPolicyId(Long id);
}
