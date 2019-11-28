package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.MomentDao;
import com.tomato.hackathon.pojo.Moment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MomentServiceImpl implements MomentService {
    @Autowired
    private MomentDao momentDao;

    @Override
    public int releaseMoment(Moment moment) {
        return momentDao.releaseMoment(moment);
    }

    @Override
    public int addClicks(String momentId) {
        return momentDao.addClicks(momentId);
    }

    @Override
    public int uploadFiles(Moment moment) {
        return momentDao.insertFiles(moment);
    }
}
