package demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.stereotype.Service;


import demo.bean.Student;
import demo.dao.StudentDAO;

@Service
public class StudentService {
	@Resource
	StudentDAO studentDAO;
	

	public List<Student> findAll() {
		return studentDAO.findAll();
	}
	
	//@Autowired
	//private DataSource datasource;

}
