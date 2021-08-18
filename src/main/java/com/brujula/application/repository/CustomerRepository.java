package com.brujula.application.repository;

import org.springframework.http.ResponseEntity;

import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.dto.CustomerDto;

public interface CustomerRepository {
    
	Customer getCustomer(int id);
	ResponseEntity<Object> updateCustomer(int id, CustomerDto customerDto);
	ResponseEntity<Object> crearCustomer(int id, CustomerDto customer_Model);
	
}
