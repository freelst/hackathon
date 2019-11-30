package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.CommercialTenantDao;
import com.tomato.hackathon.dao.MomentDao;
import com.tomato.hackathon.pojo.CommercialTenant;
import com.tomato.hackathon.pojo.Moment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MomentServiceImpl implements MomentService {
    @Autowired
    private MomentDao momentDao;

    @Autowired
    private CommercialTenantDao commercialTenantDao;

    @Override
    public int releaseMoment(Moment moment) {
        return momentDao.releaseMoment(moment);
    }

    @Override
    public int addClicks(String momentId) {
        return momentDao.addClicks(momentId);
    }

    @Override
    public List<Moment> getMomentsForAllCommercialTenant() {
        List<Moment> moments = momentDao.getMomentsForAllCommercialTenant();
        Map<String, Integer> momentMap = new HashMap<>();
        List<Moment> results = new ArrayList<>();
        for (Moment moment : moments) {
            if (!momentMap.containsKey(moment.getCommercialTenantId())) {
                results.add(moment);
                momentMap.put(moment.getCommercialTenantId(), moment.getClicks());
            }
        }

        return results;
    }

    @Override
    public List<Moment> getMomentsByCommercialTenantId(String commercialTenantId) {
        return momentDao.getMomentsByCommercialTenantId(commercialTenantId);
    }

    @Override
    public List<CommercialTenant> getListByCustomerOrder(String openId) {
        return commercialTenantDao.getListByCustomerOrder(openId);
    }

    @Override
    public String getCommercialTenantIdByMomentId(String momentId) {
        return momentDao.getCommercialTenantIdByMomentId(momentId);
    }

    @Override
    public List<Moment> getListByOpenId(String openId) {
        return momentDao.getListByOpenId(openId);
    }
}
