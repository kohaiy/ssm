package cn.jbit.mybatisdemo.dao.impl;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.jbit.mybatisdemo.dao.IEmpDao;
import cn.jbit.mybatisdemo.entity.Emp;

public class IEmpDaoImpl implements IEmpDao {

	public List<Emp> selectAll() {
		String resourse = "mybatis-config.xml";
		Reader reader = null;
		SqlSessionFactory factory = null;
		SqlSession session = null;
		List<Emp> list = new ArrayList<Emp>();
		try {
			reader = Resources.getResourceAsReader(resourse);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(reader);
			session = factory.openSession();
			list = session
					.selectList("cn.jbit.mybatisdemo.dao.IEmpDao.selectAll");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public Emp selectOne() {
		String resourse = "mybatis-config.xml";
		Reader reader = null;
		SqlSessionFactory factory = null;
		SqlSession session = null;
		Emp emp = null;
		try {
			reader = Resources.getResourceAsReader(resourse);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(reader);
			session = factory.openSession();
			emp = session
					.selectOne("cn.jbit.mybatisdemo.dao.IEmpDao.selectOne");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp;
	}

	public Emp selectByEmpno(int empno) {
		String resourse = "mybatis-config.xml";
		Reader reader = null;
		SqlSessionFactory factory = null;
		SqlSession session = null;
		Emp emp = null;
		try {
			reader = Resources.getResourceAsReader(resourse);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(reader);
			session = factory.openSession();
			emp = session
					.selectOne("cn.jbit.mybatisdemo.dao.IEmpDao.selectByEmpno",empno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp;
	}

}
