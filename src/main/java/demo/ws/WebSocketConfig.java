package demo.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
//启用webSocket注入,表明这是一个websocket注入类
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Bean
	ServerEndpointExporter  serverEndpointExporter(){
		return new ServerEndpointExporter();
		
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("注册成功");
		registry.addHandler(new WebSocketHandler(), "/ws").addInterceptors(new HandshakeInterceptor())
				.setAllowedOrigins("http://localhost:8081");
	}

	

}
