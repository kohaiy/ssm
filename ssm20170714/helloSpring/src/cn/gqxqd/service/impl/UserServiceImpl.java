package cn.gqxqd.service.impl;

import cn.gqxqd.dao.IUserDao;
import cn.gqxqd.entity.User;
import cn.gqxqd.service.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addUser(User user) {
		if (user.getUsername() == null || "".equals(user.getUsername())) {
			System.out.println("�û�������Ϊ�գ�");
			return false;
		}
		return userDao.addUser(user);
	}

}