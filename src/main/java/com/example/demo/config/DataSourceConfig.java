//package com.example.demo.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
//import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
//import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
//import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StringUtils;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @Author YYT
// * @Date 2022/3/28 14:11
// **/
//@Configuration
//public class DataSourceConfig {
//
//    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final int MIN_IDLE = 2;
//    private static final int MAX_IDLE = 30;
//
//    @Bean
//    DataSource getShardingDataSource() throws SQLException {
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTableRuleConfigs().add(getUcDepartmentTableRuleConfiguration());
//        shardingRuleConfig.getTableRuleConfigs().add(getUcUserTableRuleConfiguration());
//        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new Properties());
//    }
//
//    TableRuleConfiguration getUcDepartmentTableRuleConfiguration() {
//        TableRuleConfiguration result = new TableRuleConfiguration("uc_department");
//        result.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("uc_department", new DepartmentPreciseShardingAlgorithm()));
//        return result;
//    }
//
//    TableRuleConfiguration getUcUserTableRuleConfiguration() {
//        TableRuleConfiguration result = new TableRuleConfiguration("uc_user");
//        result.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("uc_user",
//                (PreciseShardingAlgorithm<String>) (availableTargetNames, shardingValue) -> {
//                    String value = shardingValue.getValue().substring(0, 2);
//                    return "user" + value;
//                }));
//        return result;
//    }
//
//
//
//    Map<String, DataSource> createDataSourceMap() {
//        Map<String, DataSource> result = new HashMap<>();
//        HikariDataSource dataSource1 = new HikariDataSource();
//        dataSource1.setDriverClassName(MYSQL_DRIVER);
//        dataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/user11?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2b8&rewriteBatchedStatements=true&allowMultiQueries=true");
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("123456");
//        dataSource1.setMaximumPoolSize(MAX_IDLE);
//        dataSource1.setMinimumIdle(MIN_IDLE);
//        dataSource1.setPoolName("user11");
//        result.put("user11", dataSource1);
//
//        HikariDataSource dataSource2 = new HikariDataSource();
//        dataSource2.setDriverClassName(MYSQL_DRIVER);
//        dataSource2.setJdbcUrl("jdbc:mysql://localhost:3306/user33?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2b8&rewriteBatchedStatements=true&allowMultiQueries=true");
//        dataSource2.setUsername("root");
//        dataSource2.setPassword("123456");
//        dataSource2.setMaximumPoolSize(MAX_IDLE);
//        dataSource2.setMinimumIdle(MIN_IDLE);
//        dataSource2.setPoolName("user33");
//        result.put("user33", dataSource2);
//
//        HikariDataSource dataSource3 = new HikariDataSource();
//        dataSource3.setDriverClassName(MYSQL_DRIVER);
//        dataSource3.setJdbcUrl("jdbc:mysql://localhost:3306/user42?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2b8&rewriteBatchedStatements=true&allowMultiQueries=true");
//        dataSource3.setUsername("root");
//        dataSource3.setPassword("123456");
//        dataSource3.setMaximumPoolSize(MAX_IDLE);
//        dataSource3.setMinimumIdle(MIN_IDLE);
//        dataSource3.setPoolName("user11");
//
//        result.put("user42", dataSource3);
//        return result;
//    }
//}
