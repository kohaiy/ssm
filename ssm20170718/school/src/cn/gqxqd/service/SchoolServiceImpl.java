package cn.gqxqd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gqxqd.dao.SchoolDao;
import cn.gqxqd.entity.School;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public List<School> findSchoolList() {
		System.out.println("schoolService find..");
		return schoolDao.findSchoolList();
	}

}
