package com.tomato.hackathon.service;

import com.tomato.hackathon.dao.OrangeTreeDao;
import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.OrangeTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

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
        OrangeTree orangeTree = orangeTreeDao.getTreeByOpenId(openId);
        if (ObjectUtils.isEmpty(orangeTree)) {
            orangeTree = new OrangeTree();
            orangeTree.setOpenId(openId);
            orangeTree.setOrangeTreeId(UUID.randomUUID().toString());
            orangeTree.setDrumsticks(0);
            orangeTree.setWaterDrops(0);
            orangeTreeDao.insert(orangeTree);
        }
        return orangeTree;
    }

    @Override
    public int resetOrangeTree(String openId) {
        return orangeTreeDao.resetOrangeTree(openId);
    }
}
