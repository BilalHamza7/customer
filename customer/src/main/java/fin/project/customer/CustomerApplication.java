package fin.project.customer;

import fin.project.customer.controller.CustomerController;
import fin.project.customer.data.Customer;
import fin.project.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class CustomerApplication {	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
