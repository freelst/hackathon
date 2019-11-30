package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.CustomerRequest;
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
    private Gson gson = new Gson();
    @Autowired
    private ExchangeOrderService exchangeOrderService;

    @PostMapping("getExchange")
    public int getExchange(@RequestBody ExchangeOrder exchangeOrder) {
        String exchangeOrderId = UUID.randomUUID().toString();
        Date createTime = new Date();
        exchangeOrder.setExchangeOrderId(exchangeOrderId);
        exchangeOrder.setCreateTime(createTime);
        return exchangeOrderService.insert(exchangeOrder);
    }

    @PostMapping("getExchangeOrderListByOpenId")
    public String getExchangeOrderListByOpenId(@RequestBody CustomerRequest request) {
        return gson.toJson(exchangeOrderService.getListByOpenId(request.getOpenId()));
    }
}
