package demo.wsstomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import demo.wsstomp.entity.ResponseMessage;

@Configuration
@EnableWebSocketMessageBroker
public class WsConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println("Sang节点注册");
		registry.addEndpoint("/endpointSang").withSockJS();//表示添加了一个/socket端点，客户端就可以通过这个端点来进行连接。并开启sockjs支持
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		System.out.println("configureMessageBroker()");
		registry.setApplicationDestinationPrefixes("/app");//指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
		registry.enableSimpleBroker("/topic");//表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息
	//	registry.enableStompBrokerRelay("/queue").setRelayHost("localhost").setRelayPort(8877);//设置转发到消息服务(AMQ...之类的消息服务器)
	}
	
	

}
