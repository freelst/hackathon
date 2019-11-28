package com.tomato.hackathon.controller;

import com.tomato.hackathon.pojo.CashCouponOrder;
import com.tomato.hackathon.service.CashCouponOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class CashCouponOrderController {
    @Autowired
    private CashCouponOrderService cashCouponOrderService;

    @PostMapping("buyCashCoupon")
    public int buyCashCoupon(@RequestBody CashCouponOrder cashCouponOrder){
        String cashCouponOrderId = UUID.randomUUID().toString();
        cashCouponOrder.setCashCouponOrderId(cashCouponOrderId);
        Date createTime = new Date();
        cashCouponOrder.setCreateTime(createTime);
        return cashCouponOrderService.insert(cashCouponOrder);
    }
}
