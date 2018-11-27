package com.cch.cloudchasers.controller;

import com.cch.cloudchasers.model.ContractModel;
import com.cch.cloudchasers.repository.ContractModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contract")
public class ContractModelController {

    @Autowired
    private ContractModelRepository contractModelRepository;

    @GetMapping
    public Iterable<ContractModel> getAll(){
        return contractModelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractModel> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(contractModelRepository.findOne(id));
    }

    @PostMapping
    public ResponseEntity<ContractModel> create(@RequestBody ContractModel contractModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(contractModelRepository.save(contractModel));
    }
}