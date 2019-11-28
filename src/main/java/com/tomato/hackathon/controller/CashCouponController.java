package com.tomato.hackathon.controller;

import com.tomato.hackathon.pojo.CashCouponCount;
import com.tomato.hackathon.service.CashCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashCouponController {
    @Autowired
    private CashCouponService cashCouponService;

    @PostMapping("addSellCount")
    public Integer addSellCount(@RequestBody CashCouponCount cashCouponCount){
        return cashCouponService.addSellCount(cashCouponCount);
    }
}
