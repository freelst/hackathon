package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.*;
import com.tomato.hackathon.service.CashCouponOrderService;
import com.tomato.hackathon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class CashCouponOrderController {
    private Gson gson = new Gson();
    @Autowired
    private CashCouponOrderService cashCouponOrderService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("buyCashCoupon")
    public String buyCashCoupon(@RequestBody CashCouponRequest request){
        CashCouponOrder cashCouponOrder = new CashCouponOrder();
        cashCouponOrder.setCashCouponId(request.getCashCouponId());
        String cashCouponOrderId = UUID.randomUUID().toString();
        cashCouponOrder.setCashCouponOrderId(cashCouponOrderId);
        Date createTime = new Date();
        cashCouponOrder.setCreateTime(createTime);
        cashCouponOrder.setOpenId(request.getOpenId());
        cashCouponOrder.setSource(request.getCashCouponType());
        cashCouponOrder.setDrumsticks(request.getDrumsticks());
        cashCouponOrder.setCashAmount(request.getCashAmount());
        return gson.toJson(new BaseResponse(cashCouponOrderService.insert(cashCouponOrder)));
    }

    @PostMapping("getCashCouponOrderListByOpenId")
    public String getCashCouponOrderListByOpenId(@RequestBody CashCouponOrderRequest request){
        return gson.toJson(cashCouponOrderService.getCashCouponOrderListByOpenId(request));
    }

}
