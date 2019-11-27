package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.dao.OrangeTreeDao;
import com.cmbccd.hackathon.pojo.CountNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrangeTreeServiceImpl implements OrangeTreeService {
    @Autowired
    private OrangeTreeDao orangeTreeDao;
    @Override
    public int addWaterDrops(CountNumber countNumber) {
        return orangeTreeDao.addWaterDrops(countNumber);
    }

    @Override
    public int addDrumsticks(CountNumber countNumber) {
        return orangeTreeDao.addDrumsticks(countNumber);
    }
}
