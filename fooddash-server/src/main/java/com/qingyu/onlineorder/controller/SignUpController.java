package com.qingyu.onlineorder.controller;
import com.qingyu.onlineorder.entity.Customer;
import com.qingyu.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {

    private CustomerService customerService;

    @Autowired
    public SignUpController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Customer customer) {
        System.out.println("customer name " + customer.getFirstName());
        customerService.signUp(customer);
    }
}
