package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class CashCouponOrderDto {
    private String createTime;
    private String icon;
    private String name;
    private Integer discount;
    private Integer cashAmount;
    private Integer drumsticks;
}
