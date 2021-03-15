package com.kaiyu56.dev.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author: cssly
 * @date: 2021/3/12 21:49
 * @description:
 */
public class StandardRangeTableShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    //select * from table where id between a and b;
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

//        Long upper = rangeShardingValue.getValueRange().upperEndpoint();
//        Long lower = rangeShardingValue.getValueRange().lowerEndpoint();
        String logicTableName = rangeShardingValue.getLogicTableName();

        return Arrays.asList(logicTableName + "_1", logicTableName + "_2");
    }
}
