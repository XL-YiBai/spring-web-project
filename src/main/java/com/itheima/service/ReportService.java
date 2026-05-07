package com.itheima.service;

import com.itheima.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    /**
     * 统计员工职位信息
     */
    JobOption getEmpDataJobData();

    /**
     * 统计员工性别数据
     */
    List<Map<String, Object>> getEmpGenderData();
}
