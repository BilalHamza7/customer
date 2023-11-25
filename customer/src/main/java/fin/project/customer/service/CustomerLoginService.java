package fin.project.customer.service;

import fin.project.customer.data.Customer;
import fin.project.customer.data.CustomerLogin;
import fin.project.customer.data.CustomerLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerLoginService {

    @Autowired
    CustomerLoginRepository customerLoginRepository;

    public boolean verifyUser(String username, String password)
    {
        Optional<CustomerLogin> customerLogin = customerLoginRepository.findByUsernameAndPassword(username, password);
        return customerLogin.isPresent();
    }

    public int recordCredentials(CustomerLogin createLogin) {
        var result = customerLoginRepository.save(createLogin);
        return result.getId();
    }
}
