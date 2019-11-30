package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class CashCoupon {
    private Integer keyId;
    private String cashCouponId;
    private String details;
    private String name;
    private Float cashAmount;
    private Integer discount;
    private Integer drumsticks;
    private Integer allDrumsticks;
    private Float exchangeAmount;
    private Integer sellCount;
    private String commercialTenantId;
    private String icon;
}
