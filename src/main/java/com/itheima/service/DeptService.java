package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /*
    * 查询所有部门
    * */
    List<Dept> findAll();

    /*
    * 根据 id 删除部门
    * */
    void deleteById(Integer id);

    /*
    * 新增部门
    * */
    void add(Dept dept);

    /**
     * 根据id查询部门
     */
    Dept getById(Integer id);

    /**
     * 根据 id 修改部门
     */
    void update(Dept dept);
}
