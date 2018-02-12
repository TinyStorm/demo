package demo.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//spring对mybatis的支持， 省去repository注解的配置
@Configuration
@MapperScan("demo.dao")
public class MybatisConfigure {
}
