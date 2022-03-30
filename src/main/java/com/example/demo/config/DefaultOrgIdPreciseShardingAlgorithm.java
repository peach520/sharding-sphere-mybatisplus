package com.example.demo.config;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author YYT
 * @Date 2022/3/28 10:44
 **/
@Slf4j
@NoArgsConstructor
public class DefaultOrgIdPreciseShardingAlgorithm implements StandardShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        return null;
    }

    private String getSuffix(String orgId) {
        if (StringUtils.isEmpty(orgId)) {
            return "99";
        }
        return orgId.substring(0, 2);
    }

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> preciseShardingValue) {
        String index = getSuffix(preciseShardingValue.getValue());
        List<String> datasourceList = availableTargetNames
                .stream()
                .filter(datasource -> datasource.endsWith(index))
                .collect(Collectors.toList());
        if (datasourceList.size() == 1) {
            return datasourceList.get(0);
        }
        log.error("分库路由获取失败,{}", index);
        throw new RuntimeException("分库路由获取失败");
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "CLASS_BASED";
    }
}
