package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.CashCoupon;
import com.tomato.hackathon.pojo.CashCouponCount;

import java.util.List;

public interface CashCouponDao {
    int addCount(CashCouponCount cashCouponCount);

    List<CashCoupon> getListByCommercialTenantId(String commercialTenantId);

    List<CashCoupon> getCashCouponListByFreshType();

}
