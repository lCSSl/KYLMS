package com.kaiyu56.dev.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author: cssly
 * @date: 2021/3/12 21:49
 * @description:
 */
public class StandardPreciseTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    //select * from table where id = '' or id in ('','');
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        String columnName = preciseShardingValue.getColumnName();
        Long value = preciseShardingValue.getValue();
        BigInteger bigInteger = BigInteger.valueOf(value);
        BigInteger key = bigInteger.mod(new BigInteger("2")).add(new BigInteger("1"));
        String tableFullName = logicTableName+"_"+key;
        if (collection.contains(tableFullName)){
            return tableFullName;
        }
        throw new UnsupportedOperationException("route "+tableFullName+" is not supported, please check u config");
    }
}