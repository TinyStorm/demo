package demo.service;

import javax.annotation.Resource;

import demo.daobyhibernate.SRoleVODao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.bean.SysUser;
import demo.dao.UserDAO;
@Service
public class UserService {
	
	@Resource
	private UserDAO userDAO;
	@Autowired
	private SRoleVODao sRoleVODao;
	
	public SysUser findByName(String userName) {
		return userDAO.finByName(userName);

	}

}
