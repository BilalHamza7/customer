package fin.project.customer.controller;

import fin.project.customer.data.Customer;
import fin.project.customer.data.CustomerLogin;
import fin.project.customer.service.CustomerLoginService;
import fin.project.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerLoginService customerLoginService;

    @PostMapping("/customer/verifyCustomer")
    public boolean verifyUser(@RequestParam String username,@RequestParam String password) {
        if (customerLoginService.verifyUser(username, password)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/customer/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @PostMapping("/customer/recordCredentials")
    public int recordCredentials(@RequestBody CustomerLogin createLogin){
        return customerLoginService.recordCredentials(createLogin);

    }


//
//    @GetMapping(path = "/customers/{id}")
//    public Customer getCustomerById(@PathVariable int id) {
//        return customerService.getCustomerById(id);
//    }
//
//    @PutMapping(path = "/customers/{id}")
//    public Customer updateCustomer(@RequestBody Customer update, @PathVariable int id) {
//        return customerService.updateCustomer(update ,id);
//    }
}
