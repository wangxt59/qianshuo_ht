package com.qianshuo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qianshuo.pojo.Role;
/**
 * role数据访问接口
 * @author Administrator
 *
 */
public interface RoleDao extends JpaRepository<Role,String>,JpaSpecificationExecutor<Role>{
	
}
