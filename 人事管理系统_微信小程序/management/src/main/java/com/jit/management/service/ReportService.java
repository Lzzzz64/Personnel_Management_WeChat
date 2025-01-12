package com.jit.management.service;

import com.jit.management.pojo.ReportDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ReportService {
    /**
     * 创建入职员工excel表
     * @param reportDTO
     * @return
     */
    int createEnrollExcel(ReportDTO reportDTO);

    /**
     * 创建离职员工excel表
     * @param reportDTO
     * @return
     */
    int createDismissExcel(ReportDTO reportDTO);

    /**
     * 创建部门调转excel表
     * @param reportDTO
     * @return
     */
    int createDepartmentExcel(ReportDTO reportDTO);

    /**
     * 创建岗位调转excel表
     * @param reportDTO
     * @return
     */
    int createPositionExcel(ReportDTO reportDTO);

    /**
     * 读取人才数据文件，并添加到数据库
     * @param file
     * @return
     */
    int addByFile(MultipartFile file);
}
