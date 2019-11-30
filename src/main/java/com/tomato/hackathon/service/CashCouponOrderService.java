package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.CashCouponOrder;
import com.tomato.hackathon.pojo.CashCouponOrderDto;
import com.tomato.hackathon.pojo.CashCouponOrderRequest;

import java.util.List;

public interface CashCouponOrderService {
    int insert(CashCouponOrder cashCouponOrder);

    List<CashCouponOrderDto> getCashCouponOrderListByOpenId (CashCouponOrderRequest request);
}
