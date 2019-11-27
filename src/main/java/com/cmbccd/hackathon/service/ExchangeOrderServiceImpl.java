package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.dao.ExchangeOrderDao;
import com.cmbccd.hackathon.pojo.ExchangeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeOrderServiceImpl implements ExchangeOrderService {
    @Autowired
    ExchangeOrderDao exchangeOrderDao;
    @Override
    public int insert(ExchangeOrder exchangeOrder) {
        return exchangeOrderDao.insert(exchangeOrder);
    }
}
