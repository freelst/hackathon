package com.cmbccd.hackathon.pojo;

import lombok.Data;

@Data
public class Customer {
    // 自增键
    private Integer keyId;
    // 微信小程序OpenId 唯一键
    private String openId;
    // 昵称
    private String nickName;
    // 签名
    private String slogan;
    // 鸡腿数
    private Integer drumsticks;
    // 水滴数
    private Integer waterDrops;
}
