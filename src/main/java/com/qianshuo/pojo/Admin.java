package com.qianshuo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * admin实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="m_admin")
public class Admin implements Serializable{

	private static final long serialVersionUID = -337820391660026719L;
	@Id
	@GeneratedValue(generator = "UIDGenerator")
	@GenericGenerator(name = "UIDGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;//id
	@Column(length = 32)
	private String workerName;//员工名称
	@Column
	private String workerCode;//员工编号
	@Column
	private String loginName;//登录名
	@Column
	private String password;//密码
	@Column
	private Integer sex;//性别（0：男；1：女；2：保密）
	@Column
	private String company;//所属公司
	@Column
	private String community;//管辖社区
	@Column
	private String professional;//职位
	@Column
	private String contact;//手机号
	@Column
	private String fixedPhone;//座机
	@Column
	private String province;//省
	@Column
	private String city;//市
	@Column
	private String district;//区
	@Column
	private String headPortrait;//头像
	@Column
	private String certCode;//身份证号
	@Column
	private String email;//Email地址
	@Column
	private String qq;//QQ号
	@Column
	private String status;//状态：0，启动；1，冻结；2，锁定；3，注销
	@Column
	private String loginNum;//登陆次数
	@Column
	private Integer isfirst;//首次登陆（0，是；1，否）
	@Column
	private java.util.Date createDate;//注册时间
	@Column
	private Integer type;//1不可修改2.可修改
	@Column
	private String storeId;//store_id
	@Column
	private String sellerLoginId;//seller_login_id
	@Column
	private Integer siteId;//站点id
	@Column
	private Integer chantId;//商户id
	@Column
	private Integer rank;//0 平台管理员 1商户管理员 2商户客服 3商户运维4.店长
	@Column
	private String salt;//盐



	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(updatable = true)
	private java.util.Date updateDate;//update_date


	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFixedPhone() {
		return fixedPhone;
	}

	public void setFixedPhone(String fixedPhone) {
		this.fixedPhone = fixedPhone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

	public Integer getIsfirst() {
		return isfirst;
	}

	public void setIsfirst(Integer isfirst) {
		this.isfirst = isfirst;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getSellerLoginId() {
		return sellerLoginId;
	}

	public void setSellerLoginId(String sellerLoginId) {
		this.sellerLoginId = sellerLoginId;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getChantId() {
		return chantId;
	}

	public void setChantId(Integer chantId) {
		this.chantId = chantId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
