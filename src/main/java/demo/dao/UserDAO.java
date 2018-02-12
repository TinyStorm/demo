package demo.dao;

import org.apache.ibatis.annotations.Select;

import demo.bean.SysUser;

public interface UserDAO {
	@Select("SELECT * FROM s_user WHERE name = #{name}")
	SysUser finByName(String name);
}
