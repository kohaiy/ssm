package cn.gqxqd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gqxqd.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod().toLowerCase();
		request.getSession().setAttribute("user", "kohai");
		if ("post".equals(method)) {
			// 验证登录
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (userService.login(username, password)) {
				System.out.println("login success...");
				return "common/success";
			} else {
				System.out.println("login failure..." + userService.getError());
				return "common/error";
			}
		}
		return "user/login";
	}
}
