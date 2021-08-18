package com.brujula.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.brujula.domain.Customer;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

public interface CustomerDao extends CrudRepository<CustomerModel, Integer> {

}
