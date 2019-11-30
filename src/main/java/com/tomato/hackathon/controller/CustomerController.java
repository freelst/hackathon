package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.BaseResponse;
import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.Customer;
import com.tomato.hackathon.pojo.CustomerRequest;
import com.tomato.hackathon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private Gson gson = new Gson();
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "insertNewCustomer", method = RequestMethod.POST)
    public String insertNewCustomer(@RequestBody Customer customer) {
        Customer tempCustomer = customerService.getCustomerByOpenId(customer.getOpenId());
        if (tempCustomer == null) {
            customerService.insert(customer);
            return gson.toJson(new BaseResponse(customerService.insert(customer)));
        } else {
            return gson.toJson(new BaseResponse(0));
        }
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
    
    @RequestMapping(value = "getCustomerByOpenId", method = RequestMethod.POST)
    public String getCustomerByOpenId(@RequestBody CustomerRequest request) {
        return gson.toJson(customerService.getCustomerByOpenId(request.getOpenId()));
    }

}
