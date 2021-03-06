package com.example.demo.controller;

import com.example.demo.entity.UcDepartmentDO;
import com.example.demo.service.UcDepartmentService;
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
public class UcDepartmentController {
    private final UcDepartmentService ucDepartmentService;

    public UcDepartmentController(UcDepartmentService ucDepartmentService) {
        this.ucDepartmentService = ucDepartmentService;
    }


    @PostMapping("insertDepartment")
    public Object insert(String orgId){
        return ucDepartmentService.save(new UcDepartmentDO().setOrgId(orgId).setDeptId("testDeptId").setDeptName("testName" + orgId));
    }

    @GetMapping("queryDepartment")
    public Object getDepartmentByOrgId(String orgId){
        Map<String,Object> query = Maps.newHashMap();
        query.put("org_id",orgId);
        return ucDepartmentService.listByMap(query);
    }
}
