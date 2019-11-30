package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CommercialTenantDao;
import com.tomato.hackathon.pojo.CommercialTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommercialTenantServiceImpl implements CommercialTenantService {
    @Autowired
    private CommercialTenantDao commercialTenantDao;
    @Override
    public List<CommercialTenant> getCommercialTenantListByClicks() {
        return commercialTenantDao.getCommercialTenantListByClicks();
    }

    @Override
    public Integer addClicks(String commercialTenantId) {
        return commercialTenantDao.addClicks(commercialTenantId);
    }
}
