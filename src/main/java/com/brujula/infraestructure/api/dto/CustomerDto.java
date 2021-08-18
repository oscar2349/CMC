package com.brujula.infraestructure.api.dto;

import java.io.Serializable;

import com.brujula.domain.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NonNull;

public class CustomerDto implements Serializable {

	@JsonProperty("firstName")
	@NonNull
    private String firstName;
	
	@JsonProperty("lastName")
	@NonNull
    private String lastName;
	
	@JsonProperty("company")
    private String company;

    
    
    public static CustomerDto createCustomerDto(Customer customer){
        return new CustomerDto(customer.getFirstName(), customer.getLastName(), customer.getCompany());
    }

    private CustomerDto(String firstName, String lastName, String company) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCompany(company);
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
