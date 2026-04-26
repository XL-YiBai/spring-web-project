package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*
    * 查询所有部门数据
    * */
    // 方式一：对 createTime 和 updateTime 做手动结果映射
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select id, name, create_time, update_time from dept order by update_time desc")

    // 方式二：起别名
    // @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc")

    // 方式三：在配置文件开启 mybatis 的驼峰命名映射开关
//    map-underscore-to-camel-case: true # 开启驼峰命名映射开关（这样数据库中的 update_time 可以映射到实体类的 updateTime

    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    /*
    * 根据 id 删除部门
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /*
    * 新增部门
    * */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门
     */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 更新部门
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
