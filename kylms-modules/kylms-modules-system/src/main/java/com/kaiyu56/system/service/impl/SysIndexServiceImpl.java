package com.kaiyu56.system.service.impl;

import com.kaiyu56.system.domain.vo.WeekCount;
import com.kaiyu56.system.mapper.SysIndexMapper;
import com.kaiyu56.system.service.ISysIndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.kaiyu56.system.domain.vo.WeekCount.*;

/**
 * @author cssly
 * @date 2021/5/13
 */
@Slf4j
@Service
public class SysIndexServiceImpl implements ISysIndexService {

    @Autowired
    private SysIndexMapper indexMapper;

    @Override
    public WeekCount getVisitUserNumberBefore() {
        List<Date> visitUserDate = indexMapper.getVisitUserNumberBefore();
        WeekCount weekCount = new WeekCount();
        visitUserDate.forEach(date -> {
            int i = date.getDay() - 1;
            weekCount.set(i, (weekCount.get(i) + 1));
        });
        return weekCount;
    }

    @Override
    public WeekCount getVisitUserNumberNow() {
        List<Date> visitUserDate = indexMapper.getVisitUserNumberNow();
        WeekCount weekCount = new WeekCount();
        visitUserDate.forEach(date -> {
            int i = date.getDay() - 1;
            weekCount.set(i, (weekCount.get(i) + 1));
        });
        return weekCount;
    }
    @Override
    public WeekCount getOperNumberBefore() {
        List<Date> visitUserDate = indexMapper.getOperNumberBefore();
        WeekCount weekCount = new WeekCount();
        visitUserDate.forEach(date -> {
            int i = date.getDay() - 1;
            weekCount.set(i, (weekCount.get(i) + 1));
        });
        return weekCount;
    }
    @Override
    public WeekCount getOperNumberNow() {
        List<Date> visitUserDate = indexMapper.getOperNumberNow();
        WeekCount weekCount = new WeekCount();
        visitUserDate.forEach(date -> {
            int i = date.getDay() - 1;
            weekCount.set(i, (weekCount.get(i) + 1));
        });
        return weekCount;
    }
}
