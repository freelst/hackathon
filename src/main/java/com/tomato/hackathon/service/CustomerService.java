package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.Customer;

public interface CustomerService {
    int insert(Customer customer);

    int addDrumsticks(CountNumber countNumber);

    int addWaterDrops(CountNumber countNumber);
}
