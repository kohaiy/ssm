package cn.gqxqd.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	protected String error(HttpServletRequest request, String msg, String url, int timeout) {
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("timeout", timeout);
		return "common/error";
	}

	protected String error(HttpServletRequest request, String msg) {
		return this.error(request, msg, null, 3);
	}

	protected String success(HttpServletRequest request, String msg, String url, int timeout) {
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("timeout", timeout);
		return "common/success";
	}

	protected String success(HttpServletRequest request, String msg, String url) {
		return this.success(request, msg, url, 2);
	}
}
