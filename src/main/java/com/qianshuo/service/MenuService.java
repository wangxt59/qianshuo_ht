package com.qianshuo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.qianshuo.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import com.qianshuo.dao.MenuDao;
import com.qianshuo.pojo.Menu;

/**
 * menu服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Menu> findSearch(Map whereMap, int page, int size) {
		Specification<Menu> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return menuDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Menu> findSearch(Map whereMap) {
		Specification<Menu> specification = createSpecification(whereMap);
		return menuDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param mId
	 * @return
	 */
	public Menu findById(String mId) {
		return menuDao.findById(mId).get();
	}

	/**
	 * 增加
	 * @param menu
	 */
	public void add(Menu menu) {
		// menu.setMId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		menuDao.save(menu);
	}

	/**
	 * 修改
	 * @param menu
	 */
	public void update(Menu menu) {
		menuDao.save(menu);
	}

	/**
	 * 删除
	 * @param mId
	 */
	public void deleteById(String mId) {
		menuDao.deleteById(mId);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Menu> createSpecification(Map searchMap) {

		return new Specification<Menu>() {

			@Override
			public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // m_id
                if (searchMap.get("mId")!=null && !"".equals(searchMap.get("mId"))) {
                	predicateList.add(cb.like(root.get("mId").as(String.class), "%"+(String)searchMap.get("mId")+"%"));
                }
                // menu_id
                if (searchMap.get("menuId")!=null && !"".equals(searchMap.get("menuId"))) {
                	predicateList.add(cb.like(root.get("menuId").as(String.class), "%"+(String)searchMap.get("menuId")+"%"));
                }
                // menu_name
                if (searchMap.get("menuName")!=null && !"".equals(searchMap.get("menuName"))) {
                	predicateList.add(cb.like(root.get("menuName").as(String.class), "%"+(String)searchMap.get("menuName")+"%"));
                }
                // parentid
                if (searchMap.get("parentid")!=null && !"".equals(searchMap.get("parentid"))) {
                	predicateList.add(cb.like(root.get("parentid").as(String.class), "%"+(String)searchMap.get("parentid")+"%"));
                }
                // levels
                if (searchMap.get("levels")!=null && !"".equals(searchMap.get("levels"))) {
                	predicateList.add(cb.like(root.get("levels").as(String.class), "%"+(String)searchMap.get("levels")+"%"));
                }
                // model
                if (searchMap.get("model")!=null && !"".equals(searchMap.get("model"))) {
                	predicateList.add(cb.like(root.get("model").as(String.class), "%"+(String)searchMap.get("model")+"%"));
                }
                // 2：无效1:有效，
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+(String)searchMap.get("status")+"%"));
                }
                // xmlid
                if (searchMap.get("xmlid")!=null && !"".equals(searchMap.get("xmlid"))) {
                	predicateList.add(cb.like(root.get("xmlid").as(String.class), "%"+(String)searchMap.get("xmlid")+"%"));
                }
                // url
                if (searchMap.get("url")!=null && !"".equals(searchMap.get("url"))) {
                	predicateList.add(cb.like(root.get("url").as(String.class), "%"+(String)searchMap.get("url")+"%"));
                }
                // relate_sub_id
                if (searchMap.get("relateSubId")!=null && !"".equals(searchMap.get("relateSubId"))) {
                	predicateList.add(cb.like(root.get("relateSubId").as(String.class), "%"+(String)searchMap.get("relateSubId")+"%"));
                }
                // menu_desciption
                if (searchMap.get("menuDesciption")!=null && !"".equals(searchMap.get("menuDesciption"))) {
                	predicateList.add(cb.like(root.get("menuDesciption").as(String.class), "%"+(String)searchMap.get("menuDesciption")+"%"));
                }
                // 操作人
                if (searchMap.get("operator")!=null && !"".equals(searchMap.get("operator"))) {
                	predicateList.add(cb.like(root.get("operator").as(String.class), "%"+(String)searchMap.get("operator")+"%"));
                }
                // 菜单图片url
                if (searchMap.get("iconUrl")!=null && !"".equals(searchMap.get("iconUrl"))) {
                	predicateList.add(cb.like(root.get("iconUrl").as(String.class), "%"+(String)searchMap.get("iconUrl")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
