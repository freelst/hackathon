package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.dao.CustomerDao;
import com.cmbccd.hackathon.pojo.CountNumber;
import com.cmbccd.hackathon.pojo.Customer;
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
}
