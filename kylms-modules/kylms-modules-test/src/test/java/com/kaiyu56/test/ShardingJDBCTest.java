package com.kaiyu56.test;

import com.kaiyu56.test.domain.WaybillCargo;
import com.kaiyu56.test.mapper.WaybillCargoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.kaiyu56.test.mapper")
public class ShardingJDBCTest {
    @Resource
    private WaybillCargoMapper mapper;

    @Test
    public void addWC() {
        for (int i = 10; i > 0; i--) {
            mapper.insert(new WaybillCargo().setWaybillId(10240512L).setWaybillCargoName("垃圾").setWaybillCargoCount(1));
        }
    }
}
