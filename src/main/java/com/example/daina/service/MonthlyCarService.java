package com.example.daina.service;

import com.example.daina.entity.MonthlyCar;
import com.example.daina.entity.Page;
import com.example.daina.mapper.MonthlyCarMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:06 2019/3/26
 */
@Service
public class MonthlyCarService {
    @Autowired
    MonthlyCarMapper monthlyCarMapper;

    public Page<MonthlyCar> getMonthlyCarListByPage(Integer pageNum,
                                                    Integer pageSize,
                                                    String monthlyId,
                                                    String searchInfo) {
        PageHelper.startPage(pageNum, pageSize);
        List<MonthlyCar> monthlyCars = monthlyCarMapper.getMonthlyCarListByPage(monthlyId, searchInfo);
        Integer count = monthlyCarMapper.getMonthlyCarCount(monthlyId, searchInfo);
        Page<MonthlyCar> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(monthlyCars);
        return pageData;
    }

    public Integer addMonthlyCar(MonthlyCar monthlyCar) {
        Integer result = monthlyCarMapper.addMonthlyCar(monthlyCar);
        return result;
    }

    public Integer updateMonthlyCar(MonthlyCar monthlyCar) {
        Integer result = monthlyCarMapper.updateMonthlyCar(monthlyCar);
        return result;
    }

    public Integer getIsUsedMonthlyCarLicense(String parkingLotId, String carLicense) {
        Integer result = monthlyCarMapper.getIsUsedMonthlyCarLicense(parkingLotId, carLicense);
        return result;
    }

    public Integer deleteMonthlyCar(String monthlyCarId) {
        Integer result = monthlyCarMapper.deleteMonthlyCar(monthlyCarId);
        return result;
    }
}