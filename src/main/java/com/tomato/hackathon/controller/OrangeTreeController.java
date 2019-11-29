package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.CustomerRequest;
import com.tomato.hackathon.service.OrangeTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrangeTreeController {
    private Gson gson = new Gson();
    @Autowired
    private OrangeTreeService orangeTreeService;
    @PostMapping("addWaterDropsToOrangeTree")
    public int addWaterDropsToOrangeTree(@RequestBody CountNumber countNumber) {
        return orangeTreeService.addWaterDrops(countNumber);
    }

    @PostMapping("addDrumsticksToOrangeTree")
    public int addDrumsticksToOrangeTree(@RequestBody CountNumber countNumber) {
        return orangeTreeService.addDrumsticks(countNumber);
    }

    @PostMapping("getTreeByOpenId")
    public String getTreeByOpenId(@RequestBody CustomerRequest request) {
        return gson.toJson(orangeTreeService.getTreeByOpenId(request.getOpenId()));
    }

}
