package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.pojo.CountNumber;
import com.cmbccd.hackathon.pojo.Customer;

public interface CustomerService {
    int insert(Customer customer);

    int addDrumsticks(CountNumber countNumber);

    int addWaterDrops(CountNumber countNumber);
}
