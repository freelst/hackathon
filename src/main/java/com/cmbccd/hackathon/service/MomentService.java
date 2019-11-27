package com.cmbccd.hackathon.service;

import com.cmbccd.hackathon.pojo.Moment;

public interface MomentService {
    int releaseMoment(Moment moment);

    int addClicks(String momentId);
}
