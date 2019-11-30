package com.tomato.hackathon.controller;

import com.google.gson.Gson;
import com.tomato.hackathon.pojo.*;
import com.tomato.hackathon.service.CommercialTenantService;
import com.tomato.hackathon.service.GifUtils;
import com.tomato.hackathon.service.MomentService;
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
    private CommercialTenantService commercialTenantService;

    @Autowired
    private MomentService momentService;

    @RequestMapping(value = "releaseMoment", method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8")
    public String releaseMoment(@RequestBody Moment moment) {
        String momentId = UUID.randomUUID().toString();
        moment.setMomentId(momentId);
        int code = momentService.releaseMoment(moment);
        return gson.toJson(new BaseResponse(code));
    }

    @PostMapping("addClicks")
    public String addClicks(@RequestBody ClickRequest clickRequest){
        int code = momentService.addClicks(clickRequest.getMomentId());
        String commercialTenantId = momentService.getCommercialTenantIdByMomentId(clickRequest.getMomentId());
        commercialTenantService.addClicks(commercialTenantId);
        return gson.toJson(new BaseResponse(code));
    }

    @PostMapping("uploadFiles/{type}")
    public String uploadFiles(@PathVariable String type,
                              @RequestParam MultipartFile[] file){
        String path = "/usr/local/tomcat/webapps/ROOT/";
        String internetPath = "https://cloudzqy.com/";
        List<String> fileAddress = new ArrayList<>();
        List<String> relativeAddress = new ArrayList<>();
        try {
            for (MultipartFile multipartFile : file) {
                String fileName = UUID.randomUUID().toString();
                if (StringUtils.equals(type, Constant.VIDEO_TYPE)) {
                    fileName = fileName + ".mp4";
                } else {
                    fileName = fileName + ".jpg";
                }
                File destFile = new File(path, fileName);
                multipartFile.transferTo(destFile);
                fileAddress.add(internetPath + fileName);
                relativeAddress.add(path + fileName);
            }
            String uploadGifAddress = null;
            String uploadCoverAddress = null;
            if (StringUtils.equals(type, Constant.VIDEO_TYPE) && fileAddress.size() == 1) {
                String gifPath = GifUtils.buildGif(relativeAddress.get(0),20);
                uploadGifAddress = internetPath + gifPath.substring(gifPath.lastIndexOf("/") + 1);
                String coverPath = GifUtils.buildCover(relativeAddress.get(0));
                uploadCoverAddress = internetPath + coverPath.substring(coverPath.lastIndexOf("/") + 1);
            }
            return gson.toJson(new UploadResult(gson.toJson(fileAddress), uploadGifAddress,
                    uploadCoverAddress));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "getMomentsForAllCommercialTenant", produces = "text/json;charset=UTF-8", method = RequestMethod.POST)
    public String getMomentsForAllCommercialTenant() {
        return gson.toJson(momentService.getMomentsForAllCommercialTenant());
    }

    @RequestMapping(value = "getMomentsByCommercialTenantId",produces = "text/json;charset=UTF-8", method = RequestMethod.POST)
    public String getMomentsByCommercialTenantId(@RequestBody CommercialTenantRequest request){
        return gson.toJson(momentService.getMomentsByCommercialTenantId(request.getCommercialTenantId()));
    }

    @RequestMapping(value = "getListByCustomerOrder", produces = "text/json;charset=UTF-8", method = RequestMethod.POST)
    public String getListByCustomerOrder(@RequestBody CustomerRequest request){
        return gson.toJson(momentService.getListByCustomerOrder(request.getOpenId()));
    }

    @RequestMapping(value = "getListByOpenId", produces = "text/json;charset=UTF-8", method = RequestMethod.POST)
    public String getListByOpenId(@RequestBody CustomerRequest customerRequest){
        return gson.toJson(momentService.getListByOpenId(customerRequest.getOpenId()));
    }
}
