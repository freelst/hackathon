package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.OrangeTreeDao;
import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.OrangeTree;
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

    @Override
    public OrangeTree getTreeByOpenId(String openId) {
        return orangeTreeDao.getTreeByOpenId(openId);
    }
}
