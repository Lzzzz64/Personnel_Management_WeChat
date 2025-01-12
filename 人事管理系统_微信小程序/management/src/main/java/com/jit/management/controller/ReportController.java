package com.jit.management.controller;

import com.jit.management.pojo.ReportDTO;
import com.jit.management.result.Result;
import com.jit.management.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 创建新聘员工报表
     * @param reportDTO
     * @return
     */
    @PutMapping("/enroll")
    public Result getEnrollEmployee(@RequestBody ReportDTO reportDTO){
        if(reportDTO.getStartTime() == null) reportDTO.setStartTime(LocalDateTime.MIN);
        if(reportDTO.getEndTime() == null) reportDTO.setEndTime(LocalDateTime.now());
        System.out.println("新聘员工"+reportDTO);

        reportService.createEnrollExcel(reportDTO);
        return Result.success();
    }

    /**
     * 创建离职员工报表
     * @param reportDTO
     * @return
     */
    @PutMapping("/dismiss")
    public Result getDismissEmployee(@RequestBody ReportDTO reportDTO){
        if(reportDTO.getStartTime() == null) reportDTO.setStartTime(LocalDateTime.MIN);
        if(reportDTO.getEndTime() == null) reportDTO.setEndTime(LocalDateTime.now());
        System.out.println("离职员工"+reportDTO);

        int flag = reportService.createDismissExcel(reportDTO);
        if(flag == 0) return Result.error("下载失败");
        return Result.success();
    }

    /**
     * 创建调转部门报表
     * @param reportDTO
     * @return
     */
    @PutMapping("/department")
    public Result getDepartmentEmployee(@RequestBody ReportDTO reportDTO){
        if(reportDTO.getStartTime() == null) reportDTO.setStartTime(LocalDateTime.MIN);
        if(reportDTO.getEndTime() == null) reportDTO.setEndTime(LocalDateTime.now());
        System.out.println("调转部门"+reportDTO);

        int flag = reportService.createDepartmentExcel(reportDTO);
        if(flag == 0) return Result.error("下载失败");
        return Result.success();
    }

    /**
     * 创建调转岗位报表
     * @param reportDTO
     * @return
     */
    @PutMapping("/position")
    public Result getPositionEmployee(@RequestBody ReportDTO reportDTO){
        if(reportDTO.getStartTime() == null) reportDTO.setStartTime(LocalDateTime.MIN);
        if(reportDTO.getEndTime() == null) reportDTO.setEndTime(LocalDateTime.now());
        System.out.println("岗位部门"+reportDTO);

        int flag = reportService.createPositionExcel(reportDTO);
        if(flag == 0) return Result.error("下载失败");
        return Result.success();
    }

    /**
     * 上传人才库文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        reportService.addByFile(file);
        return Result.success();
    }
}
