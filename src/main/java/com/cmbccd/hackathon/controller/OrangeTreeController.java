package com.cmbccd.hackathon.controller;

import com.cmbccd.hackathon.pojo.CountNumber;
import com.cmbccd.hackathon.service.OrangeTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrangeTreeController {
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
}
