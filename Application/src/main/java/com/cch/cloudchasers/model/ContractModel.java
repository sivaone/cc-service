package com.cch.cloudchasers.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CC_CONTRACT_MODEL")
public class ContractModel {

    @Id
    @Column
    @SequenceGenerator(name = "contract_model_seq", sequenceName = "SEQ_CC_CM")
    @GeneratedValue(generator = "contract_model_seq", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CONTRACT_NAME")
    private String contractName;

    @Column(name = "PROVIDER_NAME")
    private String providerName;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    public ContractModel() {
   }

    public ContractModel(Long id, String contractName, String providerName, Date startDate, Date endDate) {
        this.id = id;
        this.contractName = contractName;
        this.providerName = providerName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
