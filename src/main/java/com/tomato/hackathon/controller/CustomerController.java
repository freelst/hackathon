package com.tomato.hackathon.controller;

import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.Customer;
import com.tomato.hackathon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "insertNewCustomer", method = RequestMethod.POST)
    public int insertNewCustomer(@RequestBody Customer customer) {
        try {
            return customerService.insert(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping(value = "addDrumsticks", method = RequestMethod.POST)
    public int addDrumsticks (@RequestBody CountNumber countNumber){
        try {
            return customerService.addDrumsticks(countNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping(value = "addWaterDrops", method = RequestMethod.POST)
    public int addWaterDrops(@RequestBody CountNumber countNumber) {
        try {
            return customerService.addWaterDrops(countNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
