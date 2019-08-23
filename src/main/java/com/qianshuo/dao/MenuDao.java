package com.qianshuo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qianshuo.pojo.Menu;
/**
 * menu数据访问接口
 * @author Administrator
 *
 */
public interface MenuDao extends JpaRepository<Menu,String>,JpaSpecificationExecutor<Menu>{
	
}
