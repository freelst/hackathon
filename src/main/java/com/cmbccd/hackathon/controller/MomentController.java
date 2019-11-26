package com.cmbccd.hackathon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class MomentController {
    @RequestMapping(value = "releaseMoment", method = RequestMethod.POST)
    public String releaseMoment(@RequestParam MultipartFile[] files) {
        String path = "/Users/zhaohanqi/Desktop/";
        String name = UUID.randomUUID().toString() + ".mp4";
        File destFile = new File(path, name);
        try {
            files[0].transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path + name;
    }
}
