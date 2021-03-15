package com.kaiyu56.dev;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kaiyu56.dev.domain.Dict;
import com.kaiyu56.dev.domain.User;
import com.kaiyu56.dev.domain.WaybillCargo;
import com.kaiyu56.dev.mapper.DictMapper;
import com.kaiyu56.dev.mapper.UserMapper;
import com.kaiyu56.dev.mapper.WaybillCargoMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.kaiyu56.dev.mapper")
public class ShardingJDBCTest {

    @Resource
    private WaybillCargoMapper waybillCargoMapper;
    @Resource
    private DictMapper dictMapper;

    @Resource
    private UserMapper userMapper;

    @Test
    public void addWC() {
        Date now = new Date();
        for (int i = 10; i > 0; i--) {
            waybillCargoMapper.insert(new WaybillCargo(null, 10240512L, "垃圾" + i, 20, "dev", now, "dev", now, null));
        }
    }

    @Test
    public void query() {
        QueryWrapper<WaybillCargo> wrapper = new QueryWrapper<>();
        wrapper.between("waybill_cargo_id", 577249698851586048L, 577249699552034817L);
        List<WaybillCargo> list = waybillCargoMapper.selectList(wrapper);
        list.forEach(item -> System.out.println(item));
    }

    @Test
    public void queryOrder() {
        QueryWrapper<WaybillCargo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("waybill_cargo_id");
        List<WaybillCargo> list = waybillCargoMapper.selectList(wrapper);
        list.forEach(item -> System.out.println(item));
    }

    @Test
    public void queryComplex() {
        QueryWrapper<WaybillCargo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("waybill_cargo_id");
        List<WaybillCargo> list = waybillCargoMapper.selectList(wrapper);
        list.forEach(item -> System.out.println(item));
    }

    @Test
    public void queryHint() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("wms_waybillCargo", 2);
        QueryWrapper<WaybillCargo> wrapper = new QueryWrapper<>();
        List<WaybillCargo> list = waybillCargoMapper.selectList(wrapper);
        list.forEach(item -> System.out.println(item));
        hintManager.close();
    }

    @Test
    public void addDictionary() {
        dictMapper.insert(new Dict(null, "1", "正常"));
        dictMapper.insert(new Dict(null, "0", "不正常"));
    }

    @Test
    public void addUser() {
        for (int i = 10; i > 0; i--) {
            userMapper.insert(new User(null, "" + (i % 2), "User No" + i, i + 10));
        }
    }

    @Test
    public void queryUserStatus() {
        List<User> users = userMapper.queryUserStatus();
        users.forEach(item -> System.out.println(item));
    }

    @Test
    public void masterSlaveCreate() {
        for (int i = 10; i > 0; i--) {
            dictMapper.insert(new Dict(null, ""+i, "正"+i+"常"));
        }
    }

    @Test
    public void masterSlaveRead() {
        List<Dict> list = dictMapper.selectList(null);
        list.forEach(item-> System.out.println(item));
    }
    @Test
    public void masterSlaveUpdate() {
        UpdateWrapper<Dict> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("u_status","10");
        
        dictMapper.update(new Dict(null,"10","正常"),updateWrapper);
    }


}
