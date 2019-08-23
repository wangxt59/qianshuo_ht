package com.qianshuo.service;

import com.qianshuo.dao.RoleDao;
import com.qianshuo.pojo.Role;
import com.qianshuo.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * role服务层
 * 
 * @author Administrator
 *
 */
@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Role> findSearch(Map whereMap, int page, int size) {
		Specification<Role> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return roleDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Role> findSearch(Map whereMap) {
		Specification<Role> specification = createSpecification(whereMap);
		return roleDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param roleId
	 * @return
	 */
	public Role findById(String roleId) {
		return roleDao.findById(roleId).get();
	}

	/**
	 * 增加
	 * @param role
	 */
	public void add(Role role) {
		// role.setRoleId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		roleDao.save(role);
	}

	/**
	 * 修改
	 * @param role
	 */
	public void update(Role role) {
		roleDao.save(role);
	}

	/**
	 * 删除
	 * @param roleId
	 */
	public void deleteById(String roleId) {
		roleDao.deleteById(roleId);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Role> createSpecification(Map searchMap) {

		return new Specification<Role>() {

			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // role_id
                if (searchMap.get("roleId")!=null && !"".equals(searchMap.get("roleId"))) {
                	predicateList.add(cb.like(root.get("roleId").as(String.class), "%"+(String)searchMap.get("roleId")+"%"));
                }
                // 角色名称
                if (searchMap.get("roleName")!=null && !"".equals(searchMap.get("roleName"))) {
                	predicateList.add(cb.like(root.get("roleName").as(String.class), "%"+(String)searchMap.get("roleName")+"%"));
                }
                // discribe
                if (searchMap.get("discribe")!=null && !"".equals(searchMap.get("discribe"))) {
                	predicateList.add(cb.like(root.get("discribe").as(String.class), "%"+(String)searchMap.get("discribe")+"%"));
                }
                // 1:有效，0：无效
                if (searchMap.get("statusFlg")!=null && !"".equals(searchMap.get("statusFlg"))) {
                	predicateList.add(cb.like(root.get("statusFlg").as(String.class), "%"+(String)searchMap.get("statusFlg")+"%"));
                }
                // poerator_id
                if (searchMap.get("poeratorId")!=null && !"".equals(searchMap.get("poeratorId"))) {
                	predicateList.add(cb.like(root.get("poeratorId").as(String.class), "%"+(String)searchMap.get("poeratorId")+"%"));
                }
                // 商家ID，获取这个商家下的所有权限
                if (searchMap.get("sellerId")!=null && !"".equals(searchMap.get("sellerId"))) {
                	predicateList.add(cb.like(root.get("sellerId").as(String.class), "%"+(String)searchMap.get("sellerId")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
