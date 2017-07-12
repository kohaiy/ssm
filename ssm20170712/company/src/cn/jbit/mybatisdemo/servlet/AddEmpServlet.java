package cn.jbit.mybatisdemo.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.mybatisdemo.dao.IEmpDao;
import cn.jbit.mybatisdemo.dao.impl.IEmpDaoImpl;
import cn.jbit.mybatisdemo.entity.Emp;

@SuppressWarnings("serial")
public class AddEmpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/AddEmp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf8");
		try {
			String empname = req.getParameter("empname");
			if (empname == null || "".equals(empname)) {
				throw new Exception("员工名称不能为空！");
			}
			IEmpDao empDao = new IEmpDaoImpl();
			Emp emp = new Emp();
			emp.setEmpname(empname);
			emp.setJob(req.getParameter("job"));
			String comm = req.getParameter("comm");
			if (comm != null && !comm.equals("")) {
				emp.setComm(Double.valueOf(comm));
			}
			String deptNo = req.getParameter("deptNo");
			if (deptNo != null && !"".equals(deptNo)) {
				emp.setDeptNo(Integer.parseInt(deptNo));
			}
			String hireDate = req.getParameter("hireDate");
			if (hireDate != null && !"".equals(hireDate)) {
				emp.setHireDate(new Date(hireDate));
			}
			String mgr = req.getParameter("mgr");
			if (mgr != null && !"".equals(mgr)) {
				emp.setMgr(Integer.parseInt(mgr));
			}
			String salary = req.getParameter("salary");
			if (salary != null && !"".equals(salary)) {
				emp.setSalary(Double.valueOf(salary));
			}
			empDao.insertEmp(emp);
			resp.sendRedirect("EmpList");
		} catch (Exception e) {
			resp.getWriter()
					.print("<script>alert(\"添加错误！\\\n" + e.getMessage() + "\");window.history.go(-1);</script>");
			return;
		}
	}
}
