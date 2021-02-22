package com.kaiyu56.test.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.test.domain.Test;

/**
 * 测试Service接口
 *
 * @author css
 * @date 2021-02-22
 */
public interface ITestService extends IService<Test> {
    //========================================================================
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

    /**
     * 新增测试
     *
     * @param test 测试
     * @return 结果
     */
    public int insertTest(Test test);

    /**
     * 修改测试
     *
     * @param test 测试
     * @return 结果
     */
    public int updateTest(Test test);

    /**
     * 批量删除测试
     *
     * @param ids 需要删除的测试ID
     * @return 结果
     */
    public int deleteTestByIds(Long[] ids);

    /**
     * 删除测试信息
     *
     * @param id 测试ID
     * @return 结果
     */
    public int deleteTestById(Long id);
}
