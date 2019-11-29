package com.tomato.hackathon.pojo;

import lombok.Data;

@Data
public class CommercialTenant {
    private Integer keyId;
    private String commercialTenantId;
    private String description;
    private String name;
    private String address;
    private String icon;
}
