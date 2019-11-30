package com.tomato.hackathon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
