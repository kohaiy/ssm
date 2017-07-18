package cn.gqxqd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gqxqd.dao.IUserDao;
import cn.gqxqd.entity.User;
import cn.gqxqd.service.IUserService;

@Service(value="userService")
@Resource(name="userDao")
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addUser(User user) {
		if (user.getUsername() == null || "".equals(user.getUsername())) {
			System.out.println("�û�������Ϊ�գ�");
			return false;
		}
//		System.out.println("�����û�������");
//		return true;
		return userDao.addUser(user);
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}

}