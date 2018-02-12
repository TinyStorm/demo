package demo.daobyhibernate;

import demo.bean.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface SRoleVODao extends JpaRepository<SysRole,Long> {

}
