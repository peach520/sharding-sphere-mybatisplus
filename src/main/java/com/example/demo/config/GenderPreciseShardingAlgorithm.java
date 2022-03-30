package com.example.demo.config;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author YYT
 * @Date 2022/3/28 10:44
 **/
@Slf4j
@NoArgsConstructor
public class GenderPreciseShardingAlgorithm implements StandardShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> preciseShardingValue) {
        List<String> datasourceList = availableTargetNames
                .stream()
                .filter(datasource -> datasource.endsWith(preciseShardingValue.getValue().toString()))
                .collect(Collectors.toList());
        if (datasourceList.size() == 1) {
            return datasourceList.get(0);
        }
        log.error("分表路由获取失败");
        throw new RuntimeException("分库路由获取失败");
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "CLASS_BASED";
    }
}
