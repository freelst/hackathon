package com.tomato.hackathon.controller;

import com.tomato.hackathon.pojo.ExchangeOrder;
import com.tomato.hackathon.service.ExchangeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class ExchangeOrderController {
    @Autowired
    private ExchangeOrderService exchangeOrderService;

    @PostMapping("getExchange")
    public int getExchange(@RequestBody ExchangeOrder exchangeOrder) {
        String exchangeOrderId = UUID.randomUUID().toString();
        Date createTime = new Date();
        exchangeOrder.setExchangeOrderId(exchangeOrderId);
        exchangeOrder.setCreateTime(createTime);
        return  exchangeOrderService.insert(exchangeOrder);
    }
}
