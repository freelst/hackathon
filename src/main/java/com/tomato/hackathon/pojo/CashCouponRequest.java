package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class CashCouponRequest {
    private String openId;
    private Integer drumsticks;
    private String cashCouponId;
    private String cashCouponType;
    private Integer cashAmount;
}
