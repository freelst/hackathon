package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.CashCouponOrder;
import com.tomato.hackathon.pojo.CashCouponOrderDto;
import com.tomato.hackathon.pojo.CashCouponOrderRequest;

import java.util.List;

public interface CashCouponOrderDao {
    int insert(CashCouponOrder cashCouponOrder);

    List<CashCouponOrderDto> getCashCouponOrderListByOpenId(CashCouponOrderRequest request);
}
