package fin.project.customer.service;

import fin.project.customer.data.Customer;
import fin.project.customer.data.CustomerLogin;
import fin.project.customer.data.CustomerLoginRepository;
import fin.project.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerLoginService {

    @Autowired
    CustomerLoginRepository customerLoginRepository;

    public Optional<CustomerLogin> verifyUser(String username, String password)
    {
        return customerLoginRepository.findByUsernameAndPassword(username, password);
    }

    public int recordCredentials(CustomerLogin createLogin) {
        var result = customerLoginRepository.save(createLogin);
        return result.getId();
    }

    public Optional<CustomerLogin> getCustomerLogin(int id) {
        return customerLoginRepository.findById(id);
    }

    public CustomerLogin updateCustomerLogin(CustomerLogin customerLogin, int id) {
        return customerLoginRepository.findById(id)
                .map(customerLogin1 -> {
                    customerLogin1.setUsername(customerLogin.getUsername());
                    customerLogin1.setPassword(customerLogin.getPassword());
                    return customerLoginRepository.save(customerLogin1);
                }).orElseThrow(()-> new CustomerNotFoundException(id));
    }
}
