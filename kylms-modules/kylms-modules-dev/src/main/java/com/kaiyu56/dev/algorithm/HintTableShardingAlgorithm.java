package com.kaiyu56.dev.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author: cssly
 * @date: 2021/3/12 21:49
 * @description:
 */
public class HintTableShardingAlgorithm implements HintShardingAlgorithm<Long> {
    //select * from table;
    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<Long> hintShardingValue) {
        Collection<Long> values = hintShardingValue.getValues();
        Object o = values.toArray()[0];//2
        String target = hintShardingValue.getLogicTableName() + "_" + o;
        if (collection.contains(target)) {
            return Arrays.asList(target);
        }
        throw new UnsupportedOperationException("route "+target+" is not supported, please check u config");
    }
}
