package com.tomato.hackathon.service;

import com.tomato.hackathon.pojo.Moment;

public interface MomentService {
    int releaseMoment(Moment moment);

    int addClicks(String momentId);

    int uploadFiles(Moment moment);
}
