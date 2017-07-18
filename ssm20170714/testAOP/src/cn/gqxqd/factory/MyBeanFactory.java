package cn.gqxqd.factory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import cn.gqxqd.service.IUserService;
import cn.gqxqd.service.impl.UserServiceImpl;

public class MyBeanFactory {
	
	public static IUserService createService() {
		
		final IUserService userService = new UserServiceImpl();
		
		final MyAspect myAspect = new MyAspect();
		
		IUserService proxService = (IUserService) Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), userService.getClass()
						.getInterfaces(), new InvocationHandler() {

					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						//ִ��Ǯ
						myAspect.before();
						
						//����ִ��ʱ
						Object obj = method.invoke(userService, args);
						
						//ִ�к�
						myAspect.after();
						
						return obj;
					}

				});

		return proxService;
	}
}