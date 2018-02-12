package demo.daobyhibernate;

import demo.bean.SysResourceRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SResourceRoleDao  extends JpaRepository<SysResourceRole,Long>,CrudRepository<SysResourceRole,Long>{

}
