package com.brujula.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

public interface CustomerModelDao extends CrudRepository<CustomerModel, Integer> {

}
