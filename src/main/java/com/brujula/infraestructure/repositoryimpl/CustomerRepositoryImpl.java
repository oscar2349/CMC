package com.brujula.infraestructure.repositoryimpl;

import com.brujula.application.repository.CustomerDao;
import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	
	@Autowired
	CustomerDao customerDao;
	
	
    @Override
    public Customer getCustomer(int id) {
    	CustomerModel customerModel = customerDao.findById(id).orElse(null);
        return Customer.createCustomer(customerModel.getId(), customerModel.getFirstName(), customerModel.getLastName(), customerModel.getCompany());
    }
}
