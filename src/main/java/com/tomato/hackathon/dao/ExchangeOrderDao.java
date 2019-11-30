package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.ExchangeOrder;

import java.util.List;

public interface ExchangeOrderDao {
    int insert(ExchangeOrder exchangeOrder);
    List<ExchangeOrder> getListByOpenId(String openId);
}
