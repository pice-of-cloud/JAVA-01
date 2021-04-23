package io.lvxy.v1.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import io.lvxy.v1.bean.ReadWriteSplitRoutingDataSource;
import io.lvxy.v1.bean.DataBaseContextHolder;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.aspectj.apache.bcel.util.ClassLoaderRepository.SoftHashMap;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;

@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})//这个文件在DataSourceConfiguration加载完成之后再加载MybatisConfiguration
public class MybatisConfiguration extends MybatisAutoConfiguration {

    @Resource(name="masterDataSource")
    private DataSource masterDataSource;

    @Resource(name="slaveOneDataSource")
    private DataSource slaveOneDataSource;

    @Resource(name="slaveTwoDataSource")
    private DataSource slaveTwoDataSource;


    public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ObjectProvider<TypeHandler[]> typeHandlersProvider, ObjectProvider<LanguageDriver[]> languageDriversProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, typeHandlersProvider, languageDriversProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        //放入datasource 需要mybatis的AbstractRoutingDataSource 实现主从切换
        return super.sqlSessionFactory(roundRobinDataSourceProxy());
    }

    public AbstractRoutingDataSource roundRobinDataSourceProxy(){

        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
        //proxy.
        SoftHashMap targetDataSource = new ClassLoaderRepository.SoftHashMap();
        targetDataSource.put(DataBaseContextHolder.DataBaseType.MASTER, masterDataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE1, slaveOneDataSource);
        targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE2, slaveTwoDataSource);
        //默认数据源
        proxy.setDefaultTargetDataSource(masterDataSource);
        //装入两个主从数据源
        proxy.setTargetDataSources(targetDataSource);
        return proxy;
    }

}
