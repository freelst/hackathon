package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.ExchangeOrderDao;
import com.tomato.hackathon.pojo.ExchangeOrder;
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
