package com.jit.management.controller;

import com.jit.management.pojo.Position;
import com.jit.management.pojo.PositionPageQueryDTO;
import com.jit.management.result.PageResult;
import com.jit.management.result.Result;
import com.jit.management.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("position")
@Slf4j
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/page")
    public Result findAllDepartment(PositionPageQueryDTO positionPageQueryDTO) {
        PageResult pageResult = positionService.findAllPosition(positionPageQueryDTO);
        return Result.success(pageResult);
    }
    @PutMapping("/update")
    public Result Update(@RequestBody Position position) {
        int result = positionService.updatePosition(position);
        if(result==1) return Result.success();
        else return Result.error("更新失败");
    }
    @PostMapping()
    public Result Insert(@RequestBody Position position) {
        int result = positionService.insertPosition(position);
        if(result==1) return Result.success();
        else return Result.error("插入失败");
    }

    @DeleteMapping()
    public Result delete(int positionId) {
        int result = positionService.deletePosition(positionId);
        if(result==1) return Result.success();
        else return Result.error("删除失败");
    }
}
