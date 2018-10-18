package com.liuz.bplan.config;

import com.liuz.bplan.annotation.MyBatisDao;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * MapperScannerConfigurer 配置
 * @Author: liuz@aotain.com
 * @Date: 2018/10/17 9:01
 */
@Configuration
// 因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
//@AutoConfigureAfter(MyBatisConfig.class)
public class MapperScannerConfigurerBean {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //获取之前注入的beanName为sqlSessionFactory的对象
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //指定xml配置文件的路径
        mapperScannerConfigurer.setBasePackage("com.liuz.bplan");
        mapperScannerConfigurer.setAnnotationClass(MyBatisDao.class);
        return mapperScannerConfigurer;
    }
}
