package cn.gqxqd.service;

import java.util.List;

import cn.gqxqd.entity.School;

public interface SchoolService {

	List<School> findSchoolList();
	
	List<School> findSchoolsByName(String name);

	boolean addSchool(School school);

	boolean deleteSchoolById(int id);
	
	boolean stopSchoolById(int id);
	
	boolean startSchoolById(int id);
}
