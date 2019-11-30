package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.OrangeTree;

public interface OrangeTreeService {
    int addWaterDrops(CountNumber countNumber);
    int addDrumsticks(CountNumber countNumber);
    OrangeTree getTreeByOpenId(String openId);
    int resetOrangeTree(String openId);
}
