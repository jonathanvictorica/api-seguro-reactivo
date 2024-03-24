package com.jmg.seguros.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("policy")
@Builder
public class Policy {

    @Id
    private Long id;
    private String policyNumber;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private LocalDateTime dateEmission;

    @Transient
    private  Set<Coverage> coverages = new HashSet<>();
    @Transient
    private  Set<Insured> insured = new HashSet<>();
    @Transient
    private  Set<Beneficiary> beneficiary = new HashSet<>();

    public Policy(Long id) {
        this.id=id;
    }
}
