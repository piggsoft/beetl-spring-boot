/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/30                           Create
 */
package com.piggsoft.beetl.spring.boot.autoconfigue;

import org.beetl.core.*;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author yaochen4
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(BeetlProperties.class)
public class BeetlAutoConfiguration {

    @Autowired
    private BeetlProperties properties;

    /**
     * 自定义函数
     */
    @Autowired(required = false)
    @Qualifier("beetlFunctions")
    private Map<String, Function> functions = null;
    /**
     * 自定义类型默认格式化器
     */
    @Autowired(required = false)
    @Qualifier("beetlTypeFormats")
    private Map<Class<?>, Format> typeFormats = null;
    /**
     * 自定义格式化器
     */
    @Autowired(required = false)
    @Qualifier("beetlFormats")
    private Map<String, Format> formats = null;
    /**
     * 自定义标签
     */
    @Autowired(required = false)
    @Qualifier("beetlTagFactorys")
    private Map<String, TagFactory> tagFactorys = null;
    /**
     * 自定义函数包
     */
    @Autowired(required = false)
    @Qualifier("beetlFunctionPackages")
    private Map<String, Object> functionPackages = null;
    /**
     * 自定义虚拟属性
     */
    @Autowired(required = false)
    @Qualifier("beetlVirtualClassAttributes")
    private Map<Class<?>, VirtualClassAttribute> virtualClassAttributes = null;
    /**
     * 自定义虚拟属性执行器
     */
    @Autowired(required = false)
    @Qualifier("beetlVirtualAttributeEvals")
    private List<VirtualAttributeEval> virtualAttributeEvals = null;
    /**
     * 异常处理器
     */
    @Autowired(required = false)
    @Qualifier("beetlErrorHandler")
    protected ErrorHandler errorHandler = null;
    /**
     * 共享变量
     */
    @Autowired(required = false)
    @Qualifier("beetlSharedVars")
    protected Map<String, Object> sharedVars = null;


    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        try {
            ClasspathResourceLoader cploder = new ClasspathResourceLoader(BeetlAutoConfiguration.class.getClassLoader(), properties.getTemplatesPath());
            if (properties.getConfig() != null) {
                beetlGroupUtilConfiguration.setConfigProperties(properties.getConfig().toProperties());
            }
            if (functions != null) {
                beetlGroupUtilConfiguration.setFunctions(functions);
            }
             if (typeFormats != null) {
                beetlGroupUtilConfiguration.setTypeFormats(typeFormats);
            }
             if (formats != null) {
                beetlGroupUtilConfiguration.setFormats(formats);
            }
             if (tagFactorys != null) {
                beetlGroupUtilConfiguration.setTagFactorys(tagFactorys);
            }
             if (functionPackages != null) {
                beetlGroupUtilConfiguration.setFunctionPackages(functionPackages);
            }
             if (virtualClassAttributes != null) {
                beetlGroupUtilConfiguration.setVirtualClassAttributes(virtualClassAttributes);
            }
             if (virtualAttributeEvals != null) {
                beetlGroupUtilConfiguration.setVirtualAttributeEvals(virtualAttributeEvals);
            }
             if (errorHandler != null) {
                beetlGroupUtilConfiguration.setErrorHandler(errorHandler);
            }
             if (sharedVars != null) {
                beetlGroupUtilConfiguration.setSharedVars(sharedVars);
            }

            beetlGroupUtilConfiguration.setResourceLoader(cploder);
            return beetlGroupUtilConfiguration;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

}
