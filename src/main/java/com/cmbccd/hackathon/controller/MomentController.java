package com.cmbccd.hackathon.controller;

import com.cmbccd.hackathon.pojo.ClickRequest;
import com.cmbccd.hackathon.pojo.Constant;
import com.cmbccd.hackathon.pojo.Moment;
import com.cmbccd.hackathon.service.GifUtils;
import com.cmbccd.hackathon.service.MomentService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MomentController {
    private Gson gson = new Gson();

    @Autowired
    private MomentService momentService;

    @RequestMapping(value = "releaseMoment", method = RequestMethod.POST)
    public int releaseMoment(@RequestParam MultipartFile[] files,
                                String openId, String commercialTenantId,
                                String type, String source, String details) {
        String path = "/Users/zhaohanqi/Desktop/";
        List<String> fileAddress = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                File destFile = new File(path, file.getOriginalFilename());
                file.transferTo(destFile);
                fileAddress.add(path + file.getOriginalFilename());
            }
            String momentId = UUID.randomUUID().toString();

            Moment moment = new Moment(momentId, openId, commercialTenantId,
                    type, gson.toJson(fileAddress), details, source);
            if (StringUtils.equals(type, Constant.VIDEO_TYPE) && fileAddress.size() == 1) {
                String gifPath = GifUtils.buildGif(fileAddress.get(0),50);
                moment.setGifAddress(gifPath);
            }
            return momentService.releaseMoment(moment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @PostMapping("addClicks")
    public int addClicks(@RequestBody ClickRequest clickRequest){
        return momentService.addClicks(clickRequest.getMomentId());
    }
}
