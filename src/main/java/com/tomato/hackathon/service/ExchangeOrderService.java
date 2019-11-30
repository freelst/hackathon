package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.ExchangeOrder;

import java.util.List;

public interface ExchangeOrderService {
    int insert(ExchangeOrder exchangeOrder);

    List<ExchangeOrder> getListByOpenId(String openId);
}
