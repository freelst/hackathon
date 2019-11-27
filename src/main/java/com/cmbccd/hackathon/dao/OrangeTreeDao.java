package com.cmbccd.hackathon.dao;

import com.cmbccd.hackathon.pojo.CountNumber;
import com.cmbccd.hackathon.pojo.OrangeTree;

public interface OrangeTreeDao {
    int insert(OrangeTree orangeTree);

    int addDrumsticks(CountNumber countNumber);

    int addWaterDrops(CountNumber countNumber);
}
