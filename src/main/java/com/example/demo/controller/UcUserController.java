package com.example.demo.controller;

import com.example.demo.entity.UcUserDO;
import com.example.demo.service.UcUserService;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author YYT
 * @Date 2022/3/25 18:26
 **/
@RestController
public class UcUserController {
    private final UcUserService userService;

    public UcUserController(UcUserService userService) {
        this.userService = userService;
    }


    @PostMapping("insertUser")
    public Object insert(String orgId, Integer gender) {

        return userService.save(new UcUserDO().setUserName("testUser" + orgId).setOrgId(orgId).setGender(gender));
    }

    @GetMapping("queryUser")
    public Object queryUser(String orgId, Integer gender) {
        Map<String, Object> query = Maps.newHashMap();
        query.put("org_id", orgId);
        query.put("gender", gender);
        return userService.listByMap(query);
    }
}
