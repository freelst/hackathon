package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.CommercialTenant;

import java.util.List;

public interface CommercialTenantService {
    List<CommercialTenant> getCommercialTenantListByClicks();

    Integer addClicks(String commercialTenantId);
}
