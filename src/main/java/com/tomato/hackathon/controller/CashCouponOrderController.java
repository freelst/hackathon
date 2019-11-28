package com.tomato.hackathon.controller;

import com.tomato.hackathon.pojo.CashCouponOrder;
import com.tomato.hackathon.service.CashCouponOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashCouponOrderController {
    @Autowired
    private CashCouponOrderService cashCouponOrderService;

    @PostMapping("buyCashCoupon")
    public int buyCashCoupon(@RequestBody CashCouponOrder cashCouponOrder){
        return cashCouponOrderService.insert(cashCouponOrder);
    }
}
