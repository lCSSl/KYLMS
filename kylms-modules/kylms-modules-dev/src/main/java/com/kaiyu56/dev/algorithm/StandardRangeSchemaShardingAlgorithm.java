package com.kaiyu56.dev.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author: cssly
 * @date: 2021/3/12 22:16
 * @description:
 * @url:
 */
public class StandardRangeSchemaShardingAlgorithm implements RangeShardingAlgorithm<Long> {
    //select * from table where id between a and b;
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
//        Range<Long> valueRange = rangeShardingValue.getValueRange();
//        String logicTableName = rangeShardingValue.getLogicTableName();
        //db$->{id%2+1} [db1,db2]
        return Arrays.asList("db1","db2");
    }
}
