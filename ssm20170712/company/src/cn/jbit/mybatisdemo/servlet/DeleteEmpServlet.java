package cn.jbit.mybatisdemo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.mybatisdemo.dao.IEmpDao;
import cn.jbit.mybatisdemo.dao.impl.IEmpDaoImpl;

@SuppressWarnings("serial")
public class DeleteEmpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empno = req.getParameter("empno");
		resp.setContentType("text/html;charset=utf-8");
		if (empno == null) {
			resp.getWriter().print("<script>alert(\"删除员工编号不能为空！\");window.history.go(-1);</script>");
		} else {
			try {
				IEmpDao empDao = new IEmpDaoImpl();
				int result = empDao.deleteEmp(Integer.parseInt(empno));
				if (result>0) {
					resp.getWriter().print("<script>alert(\"删除成功！\");window.location.href='EmpList';</script>");
				}
			} catch (Exception e) {
				resp.getWriter().print("<script>alert(\"删除出现错误！\");window.history.go(-1);</script>");
				return;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
