package com.qianshuo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * role实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="m_role")
public class Role implements Serializable{

	@Id
	private String roleId;//role_id


	
	private String roleName;//角色名称
	private String discribe;//discribe
	private java.util.Date createDate;//create_date
	private java.util.Date updateDate;//update_date
	private String statusFlg;//1:有效，0：无效
	private String poeratorId;//poerator_id
	private String sellerId;//商家ID，获取这个商家下的所有权限
	private Integer rank;//0 平台管理员 1商户管理员 2商户客服 3商户运维

	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDiscribe() {
		return discribe;
	}
	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}

	public String getPoeratorId() {
		return poeratorId;
	}
	public void setPoeratorId(String poeratorId) {
		this.poeratorId = poeratorId;
	}

	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}


	
}
