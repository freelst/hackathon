package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CashCouponOrderDao;
import com.tomato.hackathon.pojo.CashCouponOrder;
import com.tomato.hackathon.pojo.CashCouponOrderDto;
import com.tomato.hackathon.pojo.CashCouponOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CashCouponOrderServiceImpl implements CashCouponOrderService {
    @Autowired
    private CashCouponOrderDao cashCouponOrderDao;
    @Override
    public int insert(CashCouponOrder cashCouponOrder) {
        return cashCouponOrderDao.insert(cashCouponOrder);
    }

    @Override
    public List<CashCouponOrderDto> getCashCouponOrderListByOpenId(CashCouponOrderRequest request) {
        return cashCouponOrderDao.getCashCouponOrderListByOpenId(request);
    }
}
