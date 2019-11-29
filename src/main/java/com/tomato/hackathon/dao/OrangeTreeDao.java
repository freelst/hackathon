package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.OrangeTree;

public interface OrangeTreeDao {
    int insert(OrangeTree orangeTree);

    int addDrumsticks(CountNumber countNumber);

    int addWaterDrops(CountNumber countNumber);

    OrangeTree getTreeByOpenId(String openId);
}
