package com.br.hrworker.controllers;


import com.br.hrworker.entities.Worker;
import com.br.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkersController {

    @Autowired
    private WorkerRepository workerRepository;
    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.ok(workers);

    }

    @GetMapping
    public ResponseEntity<Worker> findById(@PathVariable  Long id){
        Optional<Worker> worker = workerRepository.findById(id);

        return ResponseEntity.ok(worker.get());

    }
}
