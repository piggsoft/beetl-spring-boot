# [beetl-spring-boot](https://github.com/piggsoft/beetl-spring-boot) 
一个是辅助将beetl加入到spring-boot的脚手架，开箱即用。让用户更少的关注beetl集成的配置，更多的关注于beetl本身。

## Useage
哪些需要使用模板，并同时打算使用spring-boot的系统，强烈推荐beetl-spring-boot-starter

## Get Start
* 用户在`pom.xml`文件中加入依赖
```xml
<dependency>
    <groupId>com.piggsoft</groupId>
    <artifactId>beetl-spring-boot-starter</artifactId>
    <version>0.0.3</version>
</dependency>
```
* 然后配置`application.yaml`
```
#配置模板想到classpath路径，后面须加上"/"
beetl:
  beetl:
  templates-path: templates/
#配置模板的后缀，自动读取spring.mvc.view.suffix  
spring:
  mvc:
    view:
      suffix: .html
```

## 更多配置请参考[Example](./beetl-spring-boot-example/readme.md)

## Change log
* 0.0.3 修改`@Autowired` 在`Map<String, Object>` 上的异常表现，并重新发布版本
* 0.0.2 加上后缀配置，后缀配置使用spring的`WebMvcProperties`
