package com.kaiyu56.dev.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.math.BigInteger;
import java.util.*;

/**
 * @author: cssly
 * @date: 2021/3/12 21:49
 * @description:
 */
public class ComplexTableShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    //select * from table where id between a and b;
    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeysShardingValue) {

        Range<Long> range = complexKeysShardingValue.getColumnNameAndRangeValuesMap().get("waybill_cargo_id");

        Collection<Long> waybillIdCollection = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("waybill_id");

        List<String> result = new ArrayList<>();

        for (Long waybillId : waybillIdCollection) {
            BigInteger bigInteger = BigInteger.valueOf(waybillId);
            BigInteger key = bigInteger.mod(new BigInteger("2")).add(new BigInteger("1"));
            result.add(complexKeysShardingValue.getLogicTableName()+"_"+key);
        }

        return result;
    }
}
