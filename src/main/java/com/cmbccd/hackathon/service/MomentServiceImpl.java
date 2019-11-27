package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.dao.MomentDao;
import com.cmbccd.hackathon.pojo.Moment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MomentServiceImpl implements MomentService {
    @Autowired
    private MomentDao momentDao;

    @Override
    public int releaseMoment(Moment moment) {
        return momentDao.insert(moment);
    }

    @Override
    public int addClicks(String momentId) {
        return momentDao.addClicks(momentId);
    }
}
