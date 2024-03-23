package com.jmg.seguros.service;

import com.jmg.seguros.model.Beneficiary;
import com.jmg.seguros.model.Coverage;
import com.jmg.seguros.model.Insured;
import com.jmg.seguros.model.Policy;
import com.jmg.seguros.repository.BeneficiaryRepository;
import com.jmg.seguros.repository.CoverageRepository;
import com.jmg.seguros.repository.InsuredRepository;
import com.jmg.seguros.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final BeneficiaryRepository beneficiaryRepository;
    private final CoverageRepository coverageRepository;
    private final InsuredRepository insuredRepository;

    public Mono<Policy> save(Policy policy) {
        return policyRepository.save(policy)
                .flatMap(savedPolicy -> {
                    // Guardar beneficiarios
                    Flux<Beneficiary> saveBeneficiaries = Flux.fromIterable(savedPolicy.getBeneficiary())
                            .flatMap(beneficiary -> {
                                beneficiary.setPolicyId(savedPolicy.getId());
                                return beneficiaryRepository.save(beneficiary);
                            });

                    // Guardar coberturas
                    Flux<Coverage> saveCoverages = Flux.fromIterable(savedPolicy.getCoverages())
                            .flatMap(coverage -> {
                                coverage.setPolicyId(savedPolicy.getId());
                                return coverageRepository.save(coverage);
                            });

                    // Guardar asegurados
                    Flux<Insured> saveInsureds = Flux.fromIterable(savedPolicy.getInsured())
                            .flatMap(insured -> {
                                insured.setPolicyId(savedPolicy.getId());
                                return insuredRepository.save(insured);
                            });

                    // Esperar a que todas las operaciones de guardado se completen y devolver la póliza guardada
                    return Flux.merge(saveBeneficiaries, saveCoverages, saveInsureds).then(Mono.just(savedPolicy));
                });
    }

    public Flux<Policy> search() {
        return policyRepository.findAll(Sort.by(Sort.Order.asc("id")))
                .flatMap(policy -> beneficiaryRepository.findByPolicyId(policy.getId())
                .collectList()
                .map(beneficiaries -> {
                    policy.getBeneficiary().addAll(beneficiaries);
                    return policy;
                })
                .flatMap(policy1 -> insuredRepository.findByPolicyId(policy.getId())
                        .collectList()
                        .map(insureds -> {
                            policy1.getInsured().addAll(insureds);
                            return policy1;
                        }))
                .flatMap(policy2 -> coverageRepository.findByPolicyId(policy.getId())
                        .collectList()
                        .map(coverages -> {
                            policy2.getCoverages().addAll(coverages);
                            return policy2;
                        })));
    }
}
