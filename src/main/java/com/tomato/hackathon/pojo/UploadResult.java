package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class UploadResult {
    private String fileAddress;
    private String gifAddress;
    private String coverAddress;

    public UploadResult(String fileAddress, String gifAddress, String coverAddress) {
        this.fileAddress = fileAddress;
        this.gifAddress = gifAddress;
        this.coverAddress = coverAddress;
    }
}
