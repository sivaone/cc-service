package com.cch.cloudchasers.cch.controller;

import com.cch.cloudchasers.cch.model.ContractModel;
import com.cch.cloudchasers.cch.repository.ContractModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;

@RestController
public class ContractModelController {

    @Autowired
    private ContractModelRepository contractModelRepository;

    @GetMapping("/contractModel")
    public Iterable<ContractModel> getContractModels(){
        ContractModel cm = new ContractModel(1000L, "test", new Date(), new Date());
        return Collections.singleton(cm);
    }

    @PostMapping("/contractModel")
    public ResponseEntity<ContractModel> createContractModel(@RequestBody ContractModel contractModel){
        return new ResponseEntity<>(contractModelRepository.save(contractModel), HttpStatus.CREATED);
    }
}
