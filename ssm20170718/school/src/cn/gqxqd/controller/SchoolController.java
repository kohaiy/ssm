package cn.gqxqd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("school")
public class SchoolController {

	@RequestMapping("list")
	public String gotopage(){
		return "hui/index";
	}
}
