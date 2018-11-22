package com.wangfan.spring.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author : wangfan
 * @Description :
 * @Date : 2018/11/21 10:11
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnifiedNoticeOrderDetailEntity extends UnifiedNoticeOrderEntity {

    private String couponId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
