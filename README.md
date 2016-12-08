# beetl-spring-boot
beetl auto configuration for spring boot

## Useage
auto configuration beetl for spring boot

## Get Start
* import this library from maven
```xml
<dependency>
    <groupId>com.piggsoft</groupId>
    <artifactId>beetl-spring-boot-starter</artifactId>
    <version>0.0.3</version>
</dependency>
```
* config the `application.yaml`
```
beetl:
  templates-path: templates
  config:
    html-tag-flag: true
```

## Change log
* 0.0.3 修改`@Autowired` 在`Map<String, Object>` 上的异常表现，并重新发布版本
* 0.0.2 加上后缀配置，后缀配置使用spring的`WebMvcProperties`