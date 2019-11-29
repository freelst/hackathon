package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.CommercialTenant;
import com.tomato.hackathon.pojo.Moment;

import java.util.List;

public interface MomentService {
    int releaseMoment(Moment moment);

    int addClicks(String momentId);

    List<Moment> getMomentsForAllCommercialTenant();

    List<Moment> getMomentsByCommercialTenantId(String commercialTenantId);

    List<CommercialTenant> getListByCustomerOrder(String openId);
}
