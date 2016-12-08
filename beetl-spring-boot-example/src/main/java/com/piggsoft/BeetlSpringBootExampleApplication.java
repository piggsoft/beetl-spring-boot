package com.piggsoft;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.VirtualAttributeEval;
import org.beetl.core.VirtualClassAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BeetlSpringBootExampleApplication {

	@Bean(name = "beetlSharedVars")
	public Map<String, Object> beetlSharedVars() {
		Map<String, Object> map = new HashMap<>();
		map.put("a", "b");
		return map;
	}

	@Bean(name = "beetlFunctionPackages")
	public Map<String, Object> config() {
		Map<String, Object> map = new HashMap<>();
		map.put("a", "b");
		return map;
	}


	@Bean(name = "beetlVirtualAttributeEvals")
	public List<VirtualAttributeEval> virtualAttributeEvals() {
		List<VirtualAttributeEval> list = new ArrayList<>();
		VirtualAttributeEval virtualAttributeEval = new VirtualAttributeEval() {
			@Override
			public boolean isSupport(Class c, String attributeName) {
				return false;
			}

			@Override
			public Object eval(Object o, String attributeName, Context ctx) {
				return null;
			}
		};
		list.add(virtualAttributeEval);
		return list;
	}

	@Bean(name = "beetlVirtualClassAttributes")
	public Map<Class<?>, VirtualClassAttribute> virtualClassAttributeMap() {
		Map<Class<?>, VirtualClassAttribute> map = new HashMap<>();
		map.put(BeetlSpringBootExampleApplication.class, new VirtualAttributeEval() {
			@Override
			public boolean isSupport(Class c, String attributeName) {
				return false;
			}

			@Override
			public Object eval(Object o, String attributeName, Context ctx) {
				return null;
			}
		});
		return map;
	}

	@Bean(name = "beetlFunctions")
	public Map<String, Function> functionMap() {
		Map<String, Function> map = new HashMap<>();
		map.put("aaa", new Function() {
			@Override
			public Object call(Object[] paras, Context ctx) {
				return null;
			}
		});
		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(BeetlSpringBootExampleApplication.class, args);
	}
}
