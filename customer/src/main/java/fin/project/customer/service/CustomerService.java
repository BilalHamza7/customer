package fin.project.customer.service;

import fin.project.customer.data.Customer;
import fin.project.customer.data.CustomerRepository;
import fin.project.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer)    {

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer update, int id)    {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(update.getName());
                    customer.setEmail(update.getEmail());
                    customer.setMobileNumber(update.getMobileNumber());
                    customer.setAddress(update.getAddress());
                    return customerRepository.save(customer);
                }).orElseThrow(()-> new CustomerNotFoundException(id));
    }
}
