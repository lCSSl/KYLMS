package com.kaiyu56.test.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.test.mapper.TestMapper;
import com.kaiyu56.test.domain.Test;
import com.kaiyu56.test.service.ITestService;

/**
 * 测试Service业务层处理
 *
 * @author css
 * @date 2021-02-22
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper,Test> implements ITestService
{
    @Autowired
    private TestMapper testMapper;

    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public Test selectTestById(Long id)
    {
        return testMapper.selectTestById(id);
    }

    /**
     * 查询测试列表
     *
     * @param test 测试
     * @return 测试
     */
    @Override
    public List<Test> selectTestList(Test test)
    {
        return testMapper.selectTestList(test);
    }

    /**
     * 新增测试
     *
     * @param test 测试
     * @return 结果
     */
    @Override
    public int insertTest(Test test)
    {
        test.setCreateTime(DateUtils.getNowDate());
        return testMapper.insertTest(test);
    }

    /**
     * 修改测试
     *
     * @param test 测试
     * @return 结果
     */
    @Override
    public int updateTest(Test test)
    {
        test.setUpdateTime(DateUtils.getNowDate());
        return testMapper.updateTest(test);
    }

    /**
     * 批量删除测试
     *
     * @param ids 需要删除的测试ID
     * @return 结果
     */
    @Override
    public int deleteTestByIds(Long[] ids)
    {
        return testMapper.deleteTestByIds(ids);
    }

    /**
     * 删除测试信息
     *
     * @param id 测试ID
     * @return 结果
     */
    @Override
    public int deleteTestById(Long id)
    {
        return testMapper.deleteTestById(id);
    }
}
