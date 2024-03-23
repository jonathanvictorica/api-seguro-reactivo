package com.jmg.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("policy_coverage")
public class Coverage {
    @Id
    private Long id;

    @Column("policy_id")
    private Long policyId;
    private String coverageName;
    private BigDecimal coverageValue;
    private BigDecimal coveragePremium;

}
