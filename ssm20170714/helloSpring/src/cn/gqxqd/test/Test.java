package cn.gqxqd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gqxqd.entity.User;
import cn.gqxqd.service.IUserService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		User user = (User) context.getBean("user");
		IUserService userService = (IUserService) context
				.getBean("userService");
		userService.addUser(user);
	}
}