package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.Moment;

import java.util.List;

public interface MomentDao {
    int releaseMoment(Moment moment);

    int addClicks(String momentId);

//    int insertFiles(Moment moment);
    List<Moment> getMomentsForAllCommercialTenant();

    List<Moment> getMomentsByCommercialTenantId(String CommercialTenantId);

    String getCommercialTenantIdByMomentId(String momentId);

    List<Moment> getListByOpenId(String openId);
}
