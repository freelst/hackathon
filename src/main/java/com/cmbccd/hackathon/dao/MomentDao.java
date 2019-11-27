package com.cmbccd.hackathon.dao;

import com.cmbccd.hackathon.pojo.Moment;

public interface MomentDao {
    int insert(Moment moment);

    int addClicks(String momentId);
}
