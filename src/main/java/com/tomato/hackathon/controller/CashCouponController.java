package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.CashCouponCount;
import com.tomato.hackathon.pojo.CommercialTenantRequest;
import com.tomato.hackathon.service.CashCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CashCouponController {
    private Gson gson = new Gson();

    @Autowired
    private CashCouponService cashCouponService;

    @PostMapping("addSellCount")
    public Integer addSellCount(@RequestBody CashCouponCount cashCouponCount){
        return cashCouponService.addSellCount(cashCouponCount);
    }

    @RequestMapping(value = "getCashCouponListByCommercialTenantId",
            method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public String getCashCouponListByCommercialTenantId(@RequestBody CommercialTenantRequest request)
    {
        return gson.toJson(cashCouponService.getCashCouponListByCommercialTenantId(request.getCommercialTenantId()));
    }

    @RequestMapping(value = "getCashCouponListByFreshType", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    public String getCashCouponListByFreshType(){
        return gson.toJson(cashCouponService.getCashCouponListByFreshType());
    }
}
