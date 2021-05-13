package com.kaiyu56.system.service;

import com.kaiyu56.system.domain.vo.WeekCount;

/**
 * @author cssly
 * @date 2021/5/13
 */
public interface ISysIndexService {
    WeekCount getVisitUserNumberBefore();
    WeekCount getVisitUserNumberNow();
    WeekCount getOperNumberBefore();
    WeekCount getOperNumberNow();
}
