package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CashCouponOrderDao;
import com.tomato.hackathon.pojo.CashCouponOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CashCouponOrderServiceImpl implements CashCouponOrderService {
    @Autowired
    private CashCouponOrderDao cashCouponOrderDao;
    @Override
    public int insert(CashCouponOrder cashCouponOrder) {
        return cashCouponOrderDao.insert(cashCouponOrder);
    }
}
