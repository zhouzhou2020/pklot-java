package com.example.daina.service;

import com.example.daina.entity.Monthly;
import com.example.daina.entity.Page;
import com.example.daina.mapper.MonthlyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 9:56 2019/3/26
 */
@Service
public class MonthlyService {
    @Autowired
    MonthlyMapper monthlyMapper;

    public Page<Monthly> getMonthlyListByPage(Integer pageNum,
                                              Integer pageSize,
                                              String parkingLotId,
                                              String searchInfo,
                                              String monthlyType) {
        String tag = new String("all");
        List<Monthly> monthlies;
        PageHelper.startPage(pageNum, pageSize);
        if (monthlyType.equals(tag)) {
            monthlies = monthlyMapper.getMonthlyListByPage(parkingLotId, searchInfo);
        } else {
            monthlies = monthlyMapper.getMonthlyListByPageByType(parkingLotId, searchInfo, monthlyType);
        }
        Integer count = monthlyMapper.getMonthlyCount(parkingLotId, searchInfo);
        Page<Monthly> pageData = new Page<>(pageNum, pageSize, count);
        pageData.setItems(monthlies);
        return pageData;
    }

    public String addMonthly(Monthly monthly) {
        Integer result = monthlyMapper.addMonthly(monthly);
        String monthlyId = monthly.getMonthlyId();
        return monthlyId;
    }

    public Integer updateOccupyNum(Monthly monthly) {
        Integer result = monthlyMapper.updateOccupyNum(monthly);
        return result;
    }

    public Integer deleteMonthly(String monthlyId) {
        Integer result = monthlyMapper.deleteMonthly(monthlyId);
        return result;
    }

    public Monthly getMonthlyById(String monthlyId) {
        Monthly monthly = monthlyMapper.getMonthlyById(monthlyId);
        return monthly;
    }

    public Integer updateMonthly(Monthly monthly) {
        Integer result = monthlyMapper.updateMonthly(monthly);
        return result;
    }
}
