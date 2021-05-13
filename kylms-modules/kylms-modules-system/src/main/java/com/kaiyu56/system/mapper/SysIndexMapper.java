package com.kaiyu56.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author cssly
 * @date 2021/5/13
 */
@Mapper
public interface SysIndexMapper {
    List<Date> getVisitUserNumberBefore();

    List<Date> getVisitUserNumberNow();

    List<Date> getOperNumberBefore();

    List<Date> getOperNumberNow();
}
