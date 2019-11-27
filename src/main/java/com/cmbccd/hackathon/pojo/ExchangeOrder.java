package com.cmbccd.hackathon.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ExchangeOrder {
    private Integer keyId;
    private String exchangeOrderId;
    private String openId;
    private Date createTime;
    private Float weight;
}
