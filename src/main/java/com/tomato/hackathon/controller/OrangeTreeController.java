package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.BaseResponse;
import com.tomato.hackathon.pojo.CountNumber;
import com.tomato.hackathon.pojo.Customer;
import com.tomato.hackathon.pojo.CustomerRequest;
import com.tomato.hackathon.service.CustomerService;
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

    @Autowired
    private CustomerService customerService;

    @PostMapping("addWaterDropsToOrangeTree")
    public String addWaterDropsToOrangeTree(@RequestBody CountNumber countNumber) {
        customerService.addWaterDrops(new CountNumber(-countNumber.getNumber(), countNumber.getOpenId()));
        orangeTreeService.addWaterDrops(countNumber);
        return gson.toJson(new BaseResponse(1));
    }

    @PostMapping("addDrumsticksToOrangeTree")
    public String addDrumsticksToOrangeTree(@RequestBody CountNumber countNumber) {
        customerService.addDrumsticks(new CountNumber(-countNumber.getNumber(), countNumber.getOpenId()));
        orangeTreeService.addDrumsticks(countNumber);
        return gson.toJson(new BaseResponse(1));
    }

    @PostMapping("getTreeByOpenId")
    public String getTreeByOpenId(@RequestBody CustomerRequest request) {
        return gson.toJson(orangeTreeService.getTreeByOpenId(request.getOpenId()));
    }

    @PostMapping("resetOrangeTree")
    public String resetOrangeTree (@RequestBody CustomerRequest request){
        return gson.toJson(new BaseResponse(orangeTreeService.resetOrangeTree(request.getOpenId())));
    }

}
