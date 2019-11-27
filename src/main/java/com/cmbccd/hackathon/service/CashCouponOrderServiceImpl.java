package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.dao.CashCouponOrderDao;
import com.cmbccd.hackathon.pojo.CashCouponOrder;
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
