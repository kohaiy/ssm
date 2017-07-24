package cn.gqxqd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gqxqd.entity.Student;
import cn.gqxqd.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		List<Student> list = studentService.findAll();
		request.setAttribute("studentList", list);
		return "index";
	}
}
