package cn.gqxqd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gqxqd.entity.Student;
import cn.gqxqd.service.StudentService;
import cn.gqxqd.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		String check = this.checkUserStatus(request);
		if (check != null) {
			return check;
		}
		List<Student> list = studentService.getStudentList();
		request.setAttribute("studentList", list);
		return "user/index";
	}

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
					request.getSession().setAttribute("user", username);
					return this.success(request, "登录成功！", "index.html");
				} else {
					return this.error(request, userService.getError());
				}
			} else if ("student".equals(identity)) {
				if (studentService.login(username, password)) {
					request.getSession().setAttribute("user", username);
					return this.success(request, "登录成功！", "index.html");
				} else {
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

	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
		return this.success(request, "注销成功！", "login.html");
	}
}