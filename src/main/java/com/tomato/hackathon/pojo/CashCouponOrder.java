package com.tomato.hackathon.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class CashCouponOrder {
    private Integer keyId;
    private String cashCouponOrderId;
    private String openId;
    private String details;
    private Date createTime;
    private String cashCouponId;
    /**
     * 来源：美食订单 OR 生鲜订单
     */
    private String source;

    private Integer drumsticks;

    private Integer cashAmount;
}
