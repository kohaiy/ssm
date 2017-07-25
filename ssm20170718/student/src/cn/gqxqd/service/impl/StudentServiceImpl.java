package cn.gqxqd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gqxqd.entity.Student;
import cn.gqxqd.entity.User;
import cn.gqxqd.mapper.StudentMapper;
import cn.gqxqd.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	private String error;

	public String getError() {
		return error;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = studentMapper.findAll();
		return list;
	}

	@Override
	public Student getStudentById(int id) {
		return studentMapper.get(id);
	}

	@Override
	public boolean login(String name, String password) {
		if (name == null || password == null) {
			this.error = "用户名或密码不能为空！";
			return false;
		}
		name = name.trim();
		password = password.trim();
		if ("".equals(name) || "".equals(password)) {
			this.error = "用户名或密码不能为空！";
			return false;
		}
		Student student = new Student();
		student.setName(name);
		student.setPassword(password);
		student = studentMapper.findStudent(student);
		if (student != null) {
			return true;
		}
		this.error = "用户名不存在或密码错误！";
		return false;
	}

	@Override
	public boolean register(String name, String password) {
		if (name == null || password == null) {
			this.error = "用户名或密码不能为空！";
			return false;
		}
		name = name.trim();
		password = password.trim();
		if ("".equals(name) || "".equals(password)) {
			this.error = "用户名或密码不能为空！";
			return false;
		}
		Student student = new Student();
		student.setName(name);
		student = studentMapper.findStudent(student);
		if (student != null) {
			this.error = "用户名已经存在！";
			return false;
		}
		student = new Student();
		student.setName(name);
		student.setPassword(password);
		int id = studentMapper.saveStudent(student);
		if (id < 0) {
			this.error = "注册失败！";
			return false;
		}
		return true;
	}

}
