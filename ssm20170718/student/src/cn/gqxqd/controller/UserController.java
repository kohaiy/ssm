package cn.gqxqd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gqxqd.service.StudentService;
import cn.gqxqd.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod().toLowerCase();
		if ("post".equals(method)) {
			// 验证登录
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String identity = request.getParameter("identity");
			if ("user".equals(identity)) {
				if (userService.login(username, password)) {
					System.out.println("user login success...");
					return this.success(request, "登录成功！", null);
				} else {
					System.out.println("user login failure..." + userService.getError());
					return this.error(request, userService.getError());
				}
			} else if ("student".equals(identity)) {
				if (studentService.login(username, password)) {
					System.out.println("student:" + username + " login success...");
					return this.success(request, "登录成功！", null);
				} else {
					System.out.println("student:" + username + " login failure...");
					return this.error(request, studentService.getError());
				}
			} else {
				return this.error(request, "请选择身份！");
			}
		}
		return "user/login";
	}

	@RequestMapping("register")
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod().toLowerCase();
		if ("post".equals(method)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String identity = request.getParameter("identity");
			if ("user".equals(identity)) {
				if (userService.register(username, password)) {
					return this.success(request, "注册成功！", "login.html");
				} else {
					return this.error(request, userService.getError());
				}
			} else if ("student".equals(identity)) {
				if (studentService.register(username, password)) {
					return this.success(request, "注册成功！", "login.html");
				} else {
					return this.error(request, studentService.getError());
				}
			}
			return error(request, "未知错误！");
		} else {
			return "user/register";
		}
	}
}
