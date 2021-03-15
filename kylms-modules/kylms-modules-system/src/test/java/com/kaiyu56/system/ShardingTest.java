package com.kaiyu56.system;

import com.kaiyu56.system.domain.SysDictType;
import com.kaiyu56.system.mapper.SysDictDataMapper;
import com.kaiyu56.system.mapper.SysDictTypeMapper;
import com.kaiyu56.system.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: cssly
 * @date: 2021/3/15 13:14
 * @description:
 * @url:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.kaiyu56.system.mapper")
public class ShardingTest {
    @Resource
    private SysDictDataMapper dictDataMapper;
    @Resource
    private SysDictTypeMapper dictTypeMapper;
    @Resource
    private SysUserMapper userMapper;
    @Value("${spring.datasource.dbcp2.validation-query}")
    public String defaultQuery;
    @Test
    public void testRead() {
//        SysDictType sysDictType = dictTypeMapper.selectDictTypeAll().get(0);
//        dictDataMapper.selectDictDataByType(sysDictType.getDictType()).forEach(item-> System.out.println(item));
//        SysDictType insertSDT = new SysDictType();
//        insertSDT.setDictName("Test");
//        insertSDT.setDictType("test_test_test");
//        insertSDT.setStatus("0");
//        dictTypeMapper.insertDictType(insertSDT);
//        userMapper.selectUserList(null).forEach(item-> System.out.println(item));
        System.out.println(defaultQuery);
    }
}
