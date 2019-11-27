package com.cmbccd.hackathon.pojo;

import lombok.Data;

@Data
public class CashCouponOrder {
    private Integer keyId;
    private String cashCouponOrderId;
    private String openId;
    private String details;
    private String createTime;
    private String cashCouponId;
    private String source;
}
