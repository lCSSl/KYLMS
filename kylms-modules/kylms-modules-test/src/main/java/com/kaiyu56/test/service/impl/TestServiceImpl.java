package com.kaiyu56.test.service.impl;

import java.util.List;
                                                                                import com.kaiyu56.common.core.utils.DateUtils;
            import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import com.kaiyu56.test.mapper.TestMapper;
import com.kaiyu56.test.domain.Test;
import com.kaiyu56.test.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 测试Service业务层处理
 *
 * @author css
 * @date 2021-02-25
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    /**
     * 查询测试
     *
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public Test selectTestById(Long id) {
        return baseMapper.selectTestById(id);
    }

    /**
     * 查询测试列表
     *
     * @param test 测试
     * @return 测试
     */
    @Override
    public List<Test> selectTestList(Test test) {
        return baseMapper.selectTestList(test);
    }

    }
