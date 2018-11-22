package com.wangfan.spring.springboot.controller;

import com.wangfan.spring.springboot.bean.UnifiedNoticeOrderDetailEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangfan
 * @Description :
 * @Date : 2018/11/21 11:01
 */
@RestController
public class NoticeController {

    @PostMapping("notice")
    public Object notice(@RequestBody UnifiedNoticeOrderDetailEntity entity) {

        return entity;
    }
}
