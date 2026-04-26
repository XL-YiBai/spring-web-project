package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 添加 @Slf4j 注解就相当于自动加上了 private static final Logger log = LoggerFactory.getLogger(DeptController.class);
@Slf4j
// 可以基于 @RequestMapping 放在类上，抽取公共路径前缀
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /*
    * 查询部门列表
    * */
//    @RequestMapping("/depts")
//    @GetMapping("/depts")
    @GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /*
    * 删除部门
    * */
//    @DeleteMapping("/depts")
    @DeleteMapping
    // 一旦声明了 @RequestParam 那么参数必须传递，默认 required 为 true，如果非必填就设置 false
//    public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
//    如果前端参数与方法参数名一致就不需要指定 RequestParam 【推荐】
    public Result delete(Integer id) {
        log.info("根据 ID 删除部门：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    /*
    * 新增部门
    * */
//    @PostMapping("/depts")
    @PostMapping
    // JSON格式的请求参数通常使用一个实体对象来接受
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增部门：" + dept.getName());
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据 id 查询部门
     */
//    @GetMapping("/depts/{id}")
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
//        System.out.println("根据ID查询部门：" + id);
        log.info("根据ID查询部门：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 根据 id 更新部门
     */
//    @PutMapping("/depts")
    @PutMapping
    public Result updateInfo(@RequestBody Dept dept) {
//        System.out.println("修改部门：" + dept);
        log.info("修改部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
