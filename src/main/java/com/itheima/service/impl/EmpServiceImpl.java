package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 原始分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     */
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        // 1. 调用 Mapper 接口查询总记录数
//        long total = empMapper.count();
//
//        // 2. 调用 Mapper 接口查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//
//        // 3. 封装查询结果 PageResult
//        return new PageResult<Emp>(total, rows);
//    }

    /**
     * 使用 PageHelper 插件分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     * 注意事项：
     *                 1. 使用 PageHelper 时定义的 SQL 语法结尾不能加分号；不然 PageHelper 在后面拼接 limit 语句执行会报错
     *                 2. PageHelper 仅仅能对紧跟在其后的第一个查询语句进行分页操作
     */
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 1. 在查询之前，先设置分页参数（PageHelper）
        PageHelper.startPage(page, pageSize);

        // 2. 执行查询
        List<Emp> empList = empMapper.list();

        // 3. 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
