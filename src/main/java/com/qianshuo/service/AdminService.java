package com.qianshuo.service;

import com.qianshuo.dao.AdminDao;
import com.qianshuo.pojo.Admin;
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
 * admin服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Admin> findSearch(Map whereMap, int page, int size) {
		Specification<Admin> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return adminDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Admin> findSearch(Map whereMap) {
		Specification<Admin> specification = createSpecification(whereMap);
		return adminDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param workerId
	 * @return
	 */
	public Admin findById(String workerId) {
		return adminDao.findById(workerId).get();
	}

	/**
	 * 增加
	 * @param admin
	 */
	public void add(Admin admin) {
		// admin.setWorkerId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		adminDao.save(admin);
	}

	/**
	 * 修改
	 * @param admin
	 */
	public void update(Admin admin) {
		adminDao.save(admin);
	}

	/**
	 * 删除
	 * @param workerId
	 */
	public void deleteById(String workerId) {
		adminDao.deleteById(workerId);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Admin> createSpecification(Map searchMap) {

		return new Specification<Admin>() {

			@Override
			public Predicate toPredicate(Root<Admin> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 员工id
                if (searchMap.get("workerId")!=null && !"".equals(searchMap.get("workerId"))) {
                	predicateList.add(cb.like(root.get("workerId").as(String.class), "%"+(String)searchMap.get("workerId")+"%"));
                }
                // 员工名称
                if (searchMap.get("workerName")!=null && !"".equals(searchMap.get("workerName"))) {
                	predicateList.add(cb.like(root.get("workerName").as(String.class), "%"+(String)searchMap.get("workerName")+"%"));
                }
                // 员工编号
                if (searchMap.get("workerCode")!=null && !"".equals(searchMap.get("workerCode"))) {
                	predicateList.add(cb.like(root.get("workerCode").as(String.class), "%"+(String)searchMap.get("workerCode")+"%"));
                }
                // 登录名
                if (searchMap.get("loginName")!=null && !"".equals(searchMap.get("loginName"))) {
                	predicateList.add(cb.equal(root.get("loginName").as(String.class), (String)searchMap.get("loginName")));
                }
                // 密码
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                	predicateList.add(cb.equal(root.get("password").as(String.class), (String)searchMap.get("password")));
                }
                // 所属公司
                if (searchMap.get("company")!=null && !"".equals(searchMap.get("company"))) {
                	predicateList.add(cb.like(root.get("company").as(String.class), "%"+(String)searchMap.get("company")+"%"));
                }
                // 管辖社区
                if (searchMap.get("community")!=null && !"".equals(searchMap.get("community"))) {
                	predicateList.add(cb.like(root.get("community").as(String.class), "%"+(String)searchMap.get("community")+"%"));
                }
                // 职位
                if (searchMap.get("professional")!=null && !"".equals(searchMap.get("professional"))) {
                	predicateList.add(cb.like(root.get("professional").as(String.class), "%"+(String)searchMap.get("professional")+"%"));
                }
                // 手机号
                if (searchMap.get("contact")!=null && !"".equals(searchMap.get("contact"))) {
                	predicateList.add(cb.like(root.get("contact").as(String.class), "%"+(String)searchMap.get("contact")+"%"));
                }
                // 座机
                if (searchMap.get("fixedPhone")!=null && !"".equals(searchMap.get("fixedPhone"))) {
                	predicateList.add(cb.like(root.get("fixedPhone").as(String.class), "%"+(String)searchMap.get("fixedPhone")+"%"));
                }
                // 省
                if (searchMap.get("province")!=null && !"".equals(searchMap.get("province"))) {
                	predicateList.add(cb.like(root.get("province").as(String.class), "%"+(String)searchMap.get("province")+"%"));
                }
                // 市
                if (searchMap.get("city")!=null && !"".equals(searchMap.get("city"))) {
                	predicateList.add(cb.like(root.get("city").as(String.class), "%"+(String)searchMap.get("city")+"%"));
                }
                // 区
                if (searchMap.get("district")!=null && !"".equals(searchMap.get("district"))) {
                	predicateList.add(cb.like(root.get("district").as(String.class), "%"+(String)searchMap.get("district")+"%"));
                }
                // 头像
                if (searchMap.get("headPortrait")!=null && !"".equals(searchMap.get("headPortrait"))) {
                	predicateList.add(cb.like(root.get("headPortrait").as(String.class), "%"+(String)searchMap.get("headPortrait")+"%"));
                }
                // 身份证号
                if (searchMap.get("certCode")!=null && !"".equals(searchMap.get("certCode"))) {
                	predicateList.add(cb.like(root.get("certCode").as(String.class), "%"+(String)searchMap.get("certCode")+"%"));
                }
                // Email地址
                if (searchMap.get("email")!=null && !"".equals(searchMap.get("email"))) {
                	predicateList.add(cb.like(root.get("email").as(String.class), "%"+(String)searchMap.get("email")+"%"));
                }
                // QQ号
                if (searchMap.get("qq")!=null && !"".equals(searchMap.get("qq"))) {
                	predicateList.add(cb.like(root.get("qq").as(String.class), "%"+(String)searchMap.get("qq")+"%"));
                }
                // 状态：0，启动；1，冻结；2，锁定；3，注销
                if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
                	predicateList.add(cb.like(root.get("status").as(String.class), "%"+(String)searchMap.get("status")+"%"));
                }
                // 登陆次数
                if (searchMap.get("loginNum")!=null && !"".equals(searchMap.get("loginNum"))) {
                	predicateList.add(cb.like(root.get("loginNum").as(String.class), "%"+(String)searchMap.get("loginNum")+"%"));
                }
                // store_id
                if (searchMap.get("storeId")!=null && !"".equals(searchMap.get("storeId"))) {
                	predicateList.add(cb.like(root.get("storeId").as(String.class), "%"+(String)searchMap.get("storeId")+"%"));
                }
                // seller_login_id
                if (searchMap.get("sellerLoginId")!=null && !"".equals(searchMap.get("sellerLoginId"))) {
                	predicateList.add(cb.like(root.get("sellerLoginId").as(String.class), "%"+(String)searchMap.get("sellerLoginId")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
