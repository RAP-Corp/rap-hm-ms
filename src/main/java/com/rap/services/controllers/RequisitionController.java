package com.rap.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rap.services.models.Requisition;
import com.rap.services.repositories.RequisitionRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/requisition")
public class RequisitionController {

	
	@Autowired
    private RequisitionRepository reqisitionRepository;

	@GetMapping
    public Flux<Requisition> getAllRequisitions() {
        return reqisitionRepository.findAll();
    }
	
	
}
