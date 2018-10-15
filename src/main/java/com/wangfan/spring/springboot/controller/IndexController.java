package com.wangfan.spring.springboot.controller;

import com.wangfan.spring.springboot.bean.IndexVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Chris Wang
 * @Description:
 * @Url:
 * @Params:
 * @Return:
 * @Date:2018/10/14
 * @Other:
 */
@RestController
@RequestMapping("index")
public class IndexController
{
    @GetMapping("index")
    public Object index()
    {
        IndexVo indexVo = new IndexVo();
        indexVo.setName("chris");
        return indexVo;
    }
}
