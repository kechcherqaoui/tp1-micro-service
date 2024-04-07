package org.sid.bankaccountservice.web;

import lombok.AllArgsConstructor;
import org.sid.bankaccountservice.entities.Customer;
import org.sid.bankaccountservice.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {
    private final CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}
