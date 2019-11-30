package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.CommercialTenant;

import java.util.List;

public interface CommercialTenantDao {
    List<CommercialTenant> getListByCustomerOrder(String openId);

    List<CommercialTenant> getCommercialTenantListByClicks();

    int addClicks(String CommercialTenantId);
}
