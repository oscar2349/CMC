package com.brujula.application.service;

import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.dto.CustomerDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer get(int id) {
        return repository.getCustomer(id);
    }
    
    public ResponseEntity<Object> update(int id, CustomerDto customerDto) {
        return repository.updateCustomer(id, customerDto);
    }
    
    public ResponseEntity<Object> crearCustomer(int id,CustomerDto customerDto) {
        return repository.crearCustomer(id,customerDto);
    }

    
}
