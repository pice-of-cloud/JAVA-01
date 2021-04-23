package io.lvxy.v1.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration//上边有介绍
@EnableTransactionManagement //开启事物spring提供的注解
public class DataSourceConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);

    //默认去找application.yum中的druid.type相当于将配置文件中的该值赋值给dataSourceType
    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;


    @Bean(name = "masterDataSource")
    @Primary//优先选择主数据源（原因可写可读）
    @ConfigurationProperties(prefix = "druid.master")
    //意思是从application.yum中找druid.master开头所有的信息都要放到要创建的masterDataSource并且交给spring管理
    public DataSource masterDataSource() throws SQLException {
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("========MASTER: {}=========", masterDataSource);
        return masterDataSource;
    }

    @Bean(name = "slaveOneDataSource")
    @ConfigurationProperties(prefix = "druid.slave1")
    public DataSource slaveOneDataSource() {
        DataSource slaveOneDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("========SLAVE_1: {}=========", slaveOneDataSource);
        return slaveOneDataSource;
    }

    @Bean(name = "slaveTwoDataSource")
    @ConfigurationProperties(prefix = "druid.slave2")
    public DataSource slaveTwoDataSource() {
        DataSource slaveTwoDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("========SLAVE: {}=========", slaveTwoDataSource);
        return slaveTwoDataSource;
    }

}