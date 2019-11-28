package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class UploadResult {
    private String fileAddress;
    private String gifAddress;
    private String coverAddress;
    private String momentId;

    public UploadResult(String fileAddress, String gifAddress, String coverAddress, String momentId) {
        this.fileAddress = fileAddress;
        this.gifAddress = gifAddress;
        this.coverAddress = coverAddress;
        this.momentId = momentId;
    }
}
