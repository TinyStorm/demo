package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;
@EnableAutoConfiguration
//根据导入的jar包猜想你的配置项，并帮你自动配置，如果必要的项没有配置会报错，可以使用exclude取消该项的配置
@ComponentScan
public class Application {
    public static void main(String[] args) throws Exception {
        //返回spring上下文
        SpringApplication.run(Application.class, args);

    }
}
