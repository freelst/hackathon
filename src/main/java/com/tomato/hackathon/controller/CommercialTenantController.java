package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.CommercialTenant;
import com.tomato.hackathon.service.CommercialTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommercialTenantController {
    private Gson gson = new Gson();
    @Autowired
    private CommercialTenantService commercialTenantService;

    @RequestMapping(value = "getCommercialTenantListByClicks",produces = "text/json;charset=UTF-8", method = RequestMethod.POST)
    public String getCommercialTenantListByClicks(){
        List<CommercialTenant> commercialTenants= commercialTenantService.getCommercialTenantListByClicks();
        return gson.toJson(commercialTenants);
    }
}
