package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.Customer;

public interface CustomerDao {
    int insert(Customer customer);

    int addDrumsticks(CountNumber countNumber);

    int addWaterDrops(CountNumber countNumber);

    Customer getCustomerByOpenId(String openId);
}
