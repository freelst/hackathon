package com.cmbccd.hackathon.controller;

import com.cmbccd.hackathon.pojo.ExchangeOrder;
import com.cmbccd.hackathon.service.ExchangeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeOrderController {
    @Autowired
    private ExchangeOrderService exchangeOrderService;

    @PostMapping("getExchange")
    public int getExchange(@RequestBody ExchangeOrder exchangeOrder) {
        return  exchangeOrderService.insert(exchangeOrder);
    }
}
