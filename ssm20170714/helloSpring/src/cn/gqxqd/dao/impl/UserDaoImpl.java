package cn.gqxqd.dao.impl;

import cn.gqxqd.dao.IUserDao;
import cn.gqxqd.entity.User;

public class UserDaoImpl implements IUserDao {

	public boolean addUser(User user) {
		System.out.println("--添加用户--");
		System.out.println("用户名："+user.getUsername());
		System.out.println("密码："+user.getPassword());
		System.out.println("--添加用户成功！--");
		return true;
	}

}
