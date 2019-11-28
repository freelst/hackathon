package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.Moment;

public interface MomentDao {
    int insert(Moment moment);

    int addClicks(String momentId);
}
