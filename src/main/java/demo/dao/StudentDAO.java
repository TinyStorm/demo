package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import demo.bean.Student;
//新式--将Mapper和DAO层接口合二为一
public interface StudentDAO {
	@Select("SELECT * FROM student")
	List<Student> findAll();
}
