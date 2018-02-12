package demo.security.support.service;

import demo.bean.SysResource;
import demo.bean.SysResourceRole;
import demo.bean.SysRole;
import demo.daobyhibernate.SResourceRoleDao;
import demo.daobyhibernate.SResourceVODao;
import demo.daobyhibernate.SRoleVODao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * SpringSecurity服务支持类，查询系统指定权限的所有可访问的资源集合
 */
@Service
public class SResourceRoleService {
    @Resource
    SResourceVODao sResourceVODao;
    @Resource
    SRoleVODao sRoleVODao;
    @Resource
    SResourceRoleDao sResourceRoleDao;
    /**
     * Map中key为URL,value为角色名集合
     * @return
     */
    public Map<String,Object> getResourceMap() {
        Iterable resoures=sResourceVODao.findAll();
        Iterable roles= sRoleVODao.findAll();
        Iterable resrole=sResourceRoleDao.findAll();

        Iterator resRole=resrole.iterator();
        Map<String,Object> resoureMap=new LinkedHashMap<String, Object>();
        while(resRole.hasNext()){
            Iterator rIt=resoures.iterator();
            Iterator roleIt=roles.iterator();
            SysResourceRole srr= (SysResourceRole) resRole.next();
            String urlId= srr.getResourceId();
            String url=null;
            while(rIt.hasNext()){
                SysResource sr= (SysResource) rIt.next();
                if(sr.getResourceId().equals(urlId)){
                    url=sr.getResourceString();
                }
            }
            Collection<Object> roleCando= (Collection<Object>) resoureMap.get(url);
            if(roleCando==null){
                roleCando= new LinkedList<Object>();
                resoureMap.put(url,roleCando);
            }
            int roleId=Integer.parseInt(srr.getRoleId());
            while(roleIt.hasNext()){
                SysRole sr= (SysRole) roleIt.next();
                if(sr.getId()==roleId){
                    roleCando.add(sr.getName());
                }
            }

        }

        return resoureMap;
    }
}
