package org.jiaopi.conf.mybatis;

//import com.alibaba.druid.pool.DruidDataSource;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.PropertiesFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @ClassName TestConfig
 * @Description
 * @Author Administrator
 * @Date 2020/11/2 0002 11:30
 * @Version 1.0
 */
//@Configuration
//@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"})
//public class MyBatisDataSourceConfig{
//
//    //此处的路径按照yml或properties文件路径
//    @Value("${spring.datasource.driver-class-name}")
//    private String driver;
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Bean
//    public PropertiesFactoryBean configProperties() throws Exception{
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        propertiesFactoryBean.setLocations(resolver.getResources("classpath*:application.yml"));
//        return propertiesFactoryBean;
//    }
//
//    @Bean
//    public DruidDataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setMaxActive(30);
//        dataSource.setInitialSize(10);
//        dataSource.setValidationQuery("SELECT 1");
//        dataSource.setTestOnBorrow(true);
//        return dataSource;
//    }
//
//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager() {
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(dataSource());
//        return dataSourceTransactionManager;
//    }
//
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/gitee/sunchenbin/mybatis/actable/mapping/*/*.xml"));
//        sqlSessionFactoryBean.setTypeAliasesPackage("org.jiaopi.pojo.*");
//        return sqlSessionFactoryBean;
//    }
//
//}