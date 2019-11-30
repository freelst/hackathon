package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CustomerDao;
import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public int insert(Customer customer) {
        return customerDao.insert(customer);
    }

    @Override
    public int addDrumsticks(CountNumber countNumber) {
        return customerDao.addDrumsticks(countNumber);
    }

    @Override
    public int addWaterDrops(CountNumber countNumber) {
        return customerDao.addWaterDrops(countNumber);
    }

    @Override
    public Customer getCustomerByOpenId(String openId) {
        return customerDao.getCustomerByOpenId(openId);
    }
}
