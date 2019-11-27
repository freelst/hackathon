package com.cmbccd.hackathon.dao;

import com.cmbccd.hackathon.pojo.CountNumber;
import com.cmbccd.hackathon.pojo.Customer;

public interface CustomerDao {
    int insert(Customer customer);

    int addDrumsticks(CountNumber countNumber);

    int addWaterDrops(CountNumber countNumber);
}
