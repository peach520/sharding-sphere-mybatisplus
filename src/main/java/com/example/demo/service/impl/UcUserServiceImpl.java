package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UcDepartmentDO;
import com.example.demo.entity.UcUserDO;
import com.example.demo.mapper.UcDepartmentMapper;
import com.example.demo.mapper.UcUserMapper;
import com.example.demo.service.UcDepartmentService;
import com.example.demo.service.UcUserService;
import org.springframework.stereotype.Service;

/**
 * @Author YYT
 * @Date 2022/3/25 18:24
 **/
@Service
public class UcUserServiceImpl extends ServiceImpl<UcUserMapper, UcUserDO> implements UcUserService {
}
