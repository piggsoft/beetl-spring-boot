package com.piggsoft;

import org.beetl.core.VirtualClassAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BeetlSpringBootExampleApplication {

	@Bean(name = "beetlVirtualClassAttributes")
	public Map<Class<?>, VirtualClassAttribute> virtualClassAttributeMap() {
		Map<Class<?>, VirtualClassAttribute> map = new HashMap<Class<?>, VirtualClassAttribute>();
		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(BeetlSpringBootExampleApplication.class, args);
	}
}
