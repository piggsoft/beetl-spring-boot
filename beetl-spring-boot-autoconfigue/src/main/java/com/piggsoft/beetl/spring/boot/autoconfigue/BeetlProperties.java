/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/30                           Create
 */
package com.piggsoft.beetl.spring.boot.autoconfigue;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/30
 * @since 1.0
 */
@ConfigurationProperties(prefix = BeetlProperties.BEETL_PREFIX)
public class BeetlProperties {

    public static final String BEETL_PREFIX = "beetl";

    private String templatesPath;

    public String getTemplatesPath() {
        return templatesPath;
    }

    public void setTemplatesPath(String templatesPath) {
        this.templatesPath = templatesPath;
    }
}
