package com.cmbccd.hackathon.controller;

import com.cmbccd.hackathon.pojo.GifPath;
import com.cmbccd.hackathon.service.FileEncodeUtils;
import com.cmbccd.hackathon.service.GifUtils;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GifController {
    @RequestMapping(value = "changeVideoToGif", produces = "application/json",method = RequestMethod.POST)
    public String changeVideoToGif(@RequestBody String string){
        Gson gson = new Gson();
        GifPath gifPath = gson.fromJson(string, GifPath.class);
        String path = null;
        try {
             path = GifUtils.buildGif(gifPath.getPath(), gifPath.getFrameCount());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    @RequestMapping(value = "changeVideoToMp4", produces = "application/json", method = RequestMethod.POST)
    public String changeVideoToMp4(@RequestBody String string) {
        Gson gson = new Gson();
        GifPath gifPath = gson.fromJson(string, GifPath.class);
        try {
            String mp4Path = gifPath.getPath().substring(0, gifPath.getPath().lastIndexOf(".")) + "x.mp4";
            FileEncodeUtils.encoder(gifPath.getPath(), mp4Path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
