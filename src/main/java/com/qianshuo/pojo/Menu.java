package com.qianshuo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * menu实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="m_menu")
public class Menu implements Serializable{

	@Id
	private String mId;//m_id


	
	private String menuId;//menu_id
	private String menuName;//menu_name
	private String parentid;//parentid
	private String levels;//levels
	private String model;//model
	private String status;//2：无效1:有效，
	private String xmlid;//xmlid
	private String url;//url
	private String relateSubId;//relate_sub_id
	private String menuDesciption;//menu_desciption
	private java.util.Date createDate;//添加时间
	private java.util.Date updateDate;//更新时间
	private String operator;//操作人
	private Integer sort;//sort
	private String iconUrl;//菜单图片url

	
	public String getMId() {
		return mId;
	}
	public void setMId(String mId) {
		this.mId = mId;
	}

	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getXmlid() {
		return xmlid;
	}
	public void setXmlid(String xmlid) {
		this.xmlid = xmlid;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getRelateSubId() {
		return relateSubId;
	}
	public void setRelateSubId(String relateSubId) {
		this.relateSubId = relateSubId;
	}

	public String getMenuDesciption() {
		return menuDesciption;
	}
	public void setMenuDesciption(String menuDesciption) {
		this.menuDesciption = menuDesciption;
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

	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}


	
}
