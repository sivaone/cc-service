package com.cch.cloudchasers.repository;

import com.cch.cloudchasers.model.ContractModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractModelRepository extends CrudRepository<ContractModel, Long> {

}
