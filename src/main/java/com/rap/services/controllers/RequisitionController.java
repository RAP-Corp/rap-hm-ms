package com.rap.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rap.services.models.Requisition;
import com.rap.services.repositories.RequisitionRepository;

import reactor.core.publisher.Flux;

@RestController
public class RequisitionController {

	
	@Autowired
    private RequisitionRepository reqisitionRepository;

	@RequestMapping(path="/requisition",method=RequestMethod.GET)
    public Flux<Requisition> getAllRequisitions() {
        return reqisitionRepository.findAll();
    }
	

    
    
}
