package com.kaiyu56.test.mapper;

import java.util.List;

import com.kaiyu56.test.domain.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 测试Mapper接口
 *
 * @author css
 * @date 2021-02-25
 */
public interface TestMapper extends BaseMapper<Test> {

    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    public Test selectTestById(Long id);

    /**
     * 查询测试列表
     *
     * @param test 测试
     * @return 测试集合
     */
    public List<Test> selectTestList(Test test);

}
