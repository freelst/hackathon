package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CashCouponDao;
import com.tomato.hackathon.pojo.CashCoupon;
import com.tomato.hackathon.pojo.CashCouponCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CashCouponServiceImpl implements CashCouponService {
    @Autowired
    private CashCouponDao cashCouponDao;

    @Override
    public int addSellCount(CashCouponCount cashCouponCount) {
        return cashCouponDao.addCount(cashCouponCount);
    }

    @Override
    public List<CashCoupon> getCashCouponListByCommercialTenantId(String commercialTenantId) {
        return cashCouponDao.getListByCommercialTenantId(commercialTenantId);
    }

    @Override
    public List<CashCoupon> getCashCouponListByFreshType() {
        return cashCouponDao.getCashCouponListByFreshType();
    }
}
