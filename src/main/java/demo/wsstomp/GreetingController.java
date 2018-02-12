package demo.wsstomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import demo.wsstomp.entity.RequestMessage;
import demo.wsstomp.entity.ResponseMessage;

@Controller
public class GreetingController {
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public ResponseMessage say(RequestMessage message) {
		System.out.println(message.getName());
		return new ResponseMessage("welcome," + message.getName() + " !");
	}

	@MessageMapping("/notbroadcast")
	@SendToUser(value = "/topic/getSome", broadcast = false)
	public ResponseMessage get(RequestMessage message) {
		System.out.println(message.getName());
		return new ResponseMessage("notbroadcast," + message.getName() + " !");
	}
	

	@SubscribeMapping("/init")
	public String init() {
		return "init";
	}

}
