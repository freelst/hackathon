package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CashCouponDao;
import com.tomato.hackathon.pojo.CashCouponCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CashCouponServiceImpl implements CashCouponService {
    @Autowired
    private CashCouponDao cashCouponDao;

    @Override
    public int addSellCount(CashCouponCount cashCouponCount) {
        return cashCouponDao.addCount(cashCouponCount);
    }
}
