package cn.jbit.mybatisdemo.dao;

import java.util.List;

import cn.jbit.mybatisdemo.entity.Emp;

public interface IEmpDao {

	List<Emp> selectAll();
	Emp selectOne();
	Emp selectByEmpno(int empno);
	int insertEmp(Emp emp);
	int deleteEmp(int empno);
	int updateEmp(Emp emp);
}
