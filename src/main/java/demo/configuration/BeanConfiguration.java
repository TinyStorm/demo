package demo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource
//加载xml配置文件
public class BeanConfiguration {
	//会将返回值注入到上下文中,相当于在xml配置文件中配置了一个bean
	@Bean("names")
	List<String> listBean(@Value(value = "${book.author}") String name){
		List<String> names=new ArrayList<String>();
		names.add(name);
		names.add("Meng");
		names.add("Wang");
		return names;
	}
}
