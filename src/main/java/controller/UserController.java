package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String toLogin(){
		System.out.println("进入登录界面");
		return "login";
	}
}
