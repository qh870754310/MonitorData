package monitorData.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * 某系统除了需要从自己的主要数据库上读取和管理数据外，还有一部分业务涉及到其他多个数据库，要求可以在任何方法上可以灵活指定具体要操作的数据库。
 * 为了在开发中以最简单的方法使用，本文基于注解和AOP的方法实现，
 * 在spring boot框架的项目中，添加本文实现的代码类后，只需要配置好数据源就可以直接通过注解使用，简单方便。
 * 一配置二使用
 * 1. 启动类注册动态数据源
 * 2. 配置文件中配置多个数据源
 * 3. 在需要的方法上使用注解指定数据源
 * 1、在启动类添加 @Import({DynamicDataSourceRegister.class, MProxyTransactionManagementConfiguration.class})
 * Created by Administrator on 2017/9/25.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
