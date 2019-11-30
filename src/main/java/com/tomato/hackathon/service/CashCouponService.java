package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.CashCoupon;
import com.tomato.hackathon.pojo.CashCouponCount;

import java.util.List;

public interface CashCouponService {
    int addSellCount(CashCouponCount cashCouponCount);

    List<CashCoupon> getCashCouponListByCommercialTenantId(String CommercialTenantId);

    List<CashCoupon> getCashCouponListByFreshType();
}
