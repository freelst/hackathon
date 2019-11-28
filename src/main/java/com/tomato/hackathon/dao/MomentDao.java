package com.tomato.hackathon.dao;

import com.tomato.hackathon.pojo.Moment;

public interface MomentDao {
    int releaseMoment(Moment moment);

    int addClicks(String momentId);

    int insertFiles(Moment moment);
}
