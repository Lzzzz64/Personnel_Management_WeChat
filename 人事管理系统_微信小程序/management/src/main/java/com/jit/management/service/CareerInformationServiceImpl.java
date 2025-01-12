package com.jit.management.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jit.management.mapper.CareerInformationMapper;
import com.jit.management.pojo.CareerAndForeignAndRelationPageQueryDTO;
import com.jit.management.pojo.CareerInformation;
import com.jit.management.pojo.CareerInformationVO;
import com.jit.management.result.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CareerInformationServiceImpl implements CareerInformationService{
    @Resource
    private CareerInformationMapper careerInformationMapper;
    /*
    分页查询职业生涯信息
     */
    @Override
    public PageResult pageQuery(CareerAndForeignAndRelationPageQueryDTO careerInformationDTO) {
        PageHelper.startPage(careerInformationDTO.getPage(),careerInformationDTO.getPageSize());
        Page<CareerInformationVO> page=careerInformationMapper.pageQuery(careerInformationDTO);
        List<CareerInformationVO> list = new ArrayList<CareerInformationVO>();
        for(CareerInformationVO careerInformationVO : page.getResult()){
            int employeeId = careerInformationVO.getEmployeeId();
            careerInformationVO.setCareer(careerInformationMapper.getById(employeeId));
        }
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 更新职业生涯
     * @param careerInformationVO
     */
    @Override
    public void update(CareerInformationVO careerInformationVO) {
        careerInformationMapper.deleteById(careerInformationVO.getEmployeeId());
        for(CareerInformation careerInformation : careerInformationVO.getCareer()){
            careerInformationMapper.insert(careerInformation);
        }
    }

    /**
     * 新增职业生涯
     * @param careerInformation
     * @return
     */
    @Override
    public int insert(CareerInformation careerInformation) {
        return careerInformationMapper.insert(careerInformation);
    }
}
