package demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsMsController {

	@RequestMapping("/ws/index")
	public String index(){
		return "sendmessage";
	}
}
