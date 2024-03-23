package com.jmg.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("policy_insured")
public class Insured {
    @Id
    private Long id;
    @Column("policy_id")
    private Long policyId;

    private String documentType;
    private String documentValue;
    private String name;
    private Integer orderInsured;

}
