package com.brujula.infraestructure.repositoryimpl;

import com.brujula.application.repository.CustomerModelDao;
import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.dto.CustomerDto;
import com.brujula.infraestructure.api.dto.GenericErrorResponse;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	CustomerModelDao customerModelDao;

	@Override
	public Customer getCustomer(int id) {
		CustomerModel customerModel = customerModelDao.findById(id).orElse(null);

		if (!(customerModel == null)) {

			return Customer.createCustomer(customerModel.getId(), customerModel.getFirstName(),
					customerModel.getLastName(), customerModel.getCompany());
		}

		return new Customer();

	}

	@Override
	public ResponseEntity<Object> crearCustomer(int id,CustomerDto customerDto) {
		
		Customer customer = getCustomer(id);
		if (customer.getCompany() == null) {
			
			CustomerModel customerModel = new CustomerModel(id,customerDto.getFirstName(),customerDto.getLastName(),customerDto.getCompany());
			customerModelDao.save(customerModel);
		}

		new ResponseEntity<>(new GenericErrorResponse("BFF|getEnterpriseUser|GEU02", "el customer ya existe, si desea actualizar use el metodo indicado"),
				HttpStatus.UNPROCESSABLE_ENTITY);
		return null;
	}

	@Override
	public ResponseEntity<Object> updateCustomer(int id, CustomerDto customer_Model) {

		Customer customer = getCustomer(id);
		if (customer.getCompany() == null) {
			new ResponseEntity<>(new GenericErrorResponse("BFF|getEnterpriseUser|GEU02", "Customer No registrado"),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}

		CustomerModel customerModel = new CustomerModel(id,customer_Model.getFirstName(),customer_Model.getLastName(),customer_Model.getCompany());
		customerModelDao.save(customerModel);
		return new ResponseEntity<>("Actualizado con exito", HttpStatus.ACCEPTED);
	}
}
