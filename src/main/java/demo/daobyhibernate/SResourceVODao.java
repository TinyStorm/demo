package demo.daobyhibernate;

import demo.bean.SysResource;
import demo.bean.SysResourceRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;
import java.util.Map;
@Repository
@Table(name="s_resource")
public interface SResourceVODao extends CrudRepository<SysResource,Long> {

}
