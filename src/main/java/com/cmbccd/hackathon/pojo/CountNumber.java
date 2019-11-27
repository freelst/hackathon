package com.cmbccd.hackathon.pojo;

import lombok.Data;

@Data
public class CountNumber {
    /**
     * 鸡腿或者水滴的数量
     */
    private Integer number;
    /**
     * 用户唯一ID
     */
    private String openId;
}
