package cn.gqxqd.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gqxqd.dao.SchoolDao;
import cn.gqxqd.entity.School;

@Repository("schoolDao")
public class SchoolDaoImp implements SchoolDao {

	@Override
	public List<School> findSchoolList() {
		List<School> list = new ArrayList<>();
		list.add(new School(1, "1", "1", new Date()));
		list.add(new School(2, "2", "2", new Date()));
		list.add(new School(3, "3", "3", new Date()));
		return list;
	}

}
