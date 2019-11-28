package com.tomato.hackathon.controller;

import com.tomato.hackathon.pojo.*;
import com.tomato.hackathon.service.GifUtils;
import com.tomato.hackathon.service.MomentService;
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
    public int releaseMoment(@RequestBody MomentDetails momentDetails) {
        Moment moment = new Moment(momentDetails.getMomentId(),
                momentDetails.getOpenId(), momentDetails.getCommercialTenantId(),
                momentDetails.getDetails(), momentDetails.getSource());
        return momentService.releaseMoment(moment);
    }

    @PostMapping("addClicks")
    public int addClicks(@RequestBody ClickRequest clickRequest){
        return momentService.addClicks(clickRequest.getMomentId());
    }

    @PostMapping("uploadFiles")
    public String uploadFiles(@RequestParam MultipartFile[] files, String type){
        String path = "/Users/zhaohanqi/Desktop/resources/";
        String internetPath = "https://cloudzqy.com/";
        List<String> fileAddress = new ArrayList<>();
        List<String> relativeAddress = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                File destFile = new File(path, file.getOriginalFilename());
                file.transferTo(destFile);
                fileAddress.add(internetPath + file.getOriginalFilename());
                relativeAddress.add(path + file.getOriginalFilename());
            }
            String momentId = UUID.randomUUID().toString();
            Moment moment = new Moment(momentId, type, gson.toJson(fileAddress));
            if (StringUtils.equals(type, Constant.VIDEO_TYPE) && fileAddress.size() == 1) {
                String gifPath = GifUtils.buildGif(relativeAddress.get(0),20);
                moment.setGifAddress(internetPath + gifPath.substring(gifPath.lastIndexOf("/") + 1));
                String coverPath = GifUtils.buildCover(relativeAddress.get(0));
                moment.setCoverAddress(internetPath + coverPath.substring(coverPath.lastIndexOf("/") + 1));
            }
            momentService.uploadFiles(moment);
            return gson.toJson(new UploadResult(gson.toJson(fileAddress), moment.getGifAddress(),
                    moment.getCoverAddress(), momentId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
