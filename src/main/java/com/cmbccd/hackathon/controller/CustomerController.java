package com.cmbccd.hackathon.controller;

import com.cmbccd.hackathon.pojo.Customer;
import com.cmbccd.hackathon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(name = "insertNewCustomer", method = RequestMethod.POST)
    public int insertNewCustomer(@RequestBody Customer customer) {
        try {
            return customerService.insert(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
