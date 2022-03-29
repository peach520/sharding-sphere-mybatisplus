package com.example.demo.controller;

import com.example.demo.entity.UcDepartmentDO;
import com.example.demo.service.UcDepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("insert")
    public Object insert(){
        return ucDepartmentService.save(new UcDepartmentDO().setOrgId("43a00").setDeptId("testDeptId").setDeptName("testName"));
    }
}
