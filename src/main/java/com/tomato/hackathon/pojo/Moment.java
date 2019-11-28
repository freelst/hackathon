package com.tomato.hackathon.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Moment {
    /**
     * 自增键
     */
    private Integer keyId;
    /**
     * 唯一键
     */
    private String momentId;
    /**
     * 客户唯一ID
     */
    private String openId;
    /**
     * 商户ID
     */
    private String commercialTenantId;
    /**
     * 类型 Video Or Picture
     */
    private String resourceType;
    /**
     * 文件存储地址
     */
    private String fileAddress;
    /**
     * 点击数
     */
    private Integer clicks;
    /**
     * 详细内容
     */
    private String details;
    /**
     * 来源 商户 OR 客户
     */
    private String source;
    /**
     * GIF 地址
     */
    private String gifAddress;
    /**
     * 封面 地址
     */
    private String coverAddress;

    public Moment(String momentId, String openId, String commercialTenantId, String resourceType, String fileAddress, String details, String source) {
        this.momentId = momentId;
        this.openId = openId;
        this.commercialTenantId = commercialTenantId;
        this.resourceType = resourceType;
        this.fileAddress = fileAddress;
        this.details = details;
        this.source = source;
    }

    public Moment(String momentId, String openId, String commercialTenantId, String resourceType, String fileAddress, Integer clicks, String details, String source, String gifAddress, String coverAddress) {
        this.momentId = momentId;
        this.openId = openId;
        this.commercialTenantId = commercialTenantId;
        this.resourceType = resourceType;
        this.fileAddress = fileAddress;
        this.clicks = clicks;
        this.details = details;
        this.source = source;
        this.gifAddress = gifAddress;
        this.coverAddress = coverAddress;
    }
}
