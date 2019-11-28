package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class CashCoupon {
    private Integer keyId;
    private String cashCouponId;
    private Integer sellCount;
    private String details;
    private String address;
    private String area;
    private String commercialTenantId;
    private Integer amount;
    private String icon;
}
